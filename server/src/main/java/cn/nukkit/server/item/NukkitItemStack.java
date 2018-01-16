package cn.nukkit.server.item;

import cn.nukkit.api.item.ItemStack;
import cn.nukkit.api.item.ItemStackBuilder;
import cn.nukkit.api.item.ItemType;
import cn.nukkit.api.metadata.Metadata;
import cn.nukkit.server.nbt.tag.CompoundTag;
import cn.nukkit.server.nbt.tag.StringTag;
import cn.nukkit.server.nbt.tag.Tag;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode
@ToString
public class NukkitItemStack implements ItemStack {
    private final ItemType itemType;
    private final int amount;
    private final Metadata data;
    private final String itemName;

    public NukkitItemStack(ItemType itemType, int amount, Metadata data) {
        this(itemType, amount, data, null);
    }

    public NukkitItemStack(ItemType itemType, int amount, Metadata data, String itemName) {
        this.itemType = itemType;
        this.amount = amount;
        this.data = (data == null ? itemType.defaultMetadata() : data);
        this.itemName = itemName;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public Optional<Metadata> getItemData() {
        return Optional.ofNullable(data);
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(itemName);
    }

    @Override
    public ItemStackBuilder toBuilder() {
        return new NukkitItemStackBuilder().itemType(itemType).amount(amount).itemData(data).name(itemName);
    }

    public CompoundTag toSpecificNBT() {
        List<Tag<?>> tags = new ArrayList<>();

        // Display properties
        if (itemName != null) {
            List<Tag<?>> displayTags = new ArrayList<>();
            displayTags.add(new StringTag("Name", itemName));

            tags.add(CompoundTag.createFromList("display", displayTags));
        }

        return CompoundTag.createFromList("", tags);
    }
}