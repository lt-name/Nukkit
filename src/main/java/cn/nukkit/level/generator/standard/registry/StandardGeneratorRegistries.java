package cn.nukkit.level.generator.standard.registry;

import lombok.experimental.UtilityClass;
import net.daporkchop.lib.common.cache.Cache;

/**
 * Registries for looking up the various different resources required for parsing the config for the NukkitX standard generator.
 *
 * @author DaPorkchop_
 */
@UtilityClass
public class StandardGeneratorRegistries {
    private final Cache<BiomeMapRegistry>       BIOME_MAP_REGISTRY_CACHE       = Cache.late(BiomeMapRegistry::new);
    private final Cache<BlockReplacerRegistry>  BLOCK_REPLACER_REGISTRY_CACHE  = Cache.late(BlockReplacerRegistry::new);
    private final Cache<DecoratorRegistry>      DECORATOR_REGISTRY_CACHE       = Cache.late(DecoratorRegistry::new);
    private final Cache<DensitySourceRegistry>  DENSITY_SOURCE_REGISTRY_CACHE  = Cache.late(DensitySourceRegistry::new);
    private final Cache<NoiseGeneratorRegistry> NOISE_GENERATOR_REGISTRY_CACHE = Cache.late(NoiseGeneratorRegistry::new);
    private final Cache<PopulatorRegistry>      POPULATOR_REGISTRY_CACHE       = Cache.late(PopulatorRegistry::new);

    public BiomeMapRegistry biomeMap() {
        return BIOME_MAP_REGISTRY_CACHE.get();
    }

    public BlockReplacerRegistry blockReplacer() {
        return BLOCK_REPLACER_REGISTRY_CACHE.get();
    }

    public DecoratorRegistry decorator() {
        return DECORATOR_REGISTRY_CACHE.get();
    }

    public DensitySourceRegistry densitySource() {
        return DENSITY_SOURCE_REGISTRY_CACHE.get();
    }

    public NoiseGeneratorRegistry noiseGenerator() {
        return NOISE_GENERATOR_REGISTRY_CACHE.get();
    }

    public PopulatorRegistry populator() {
        return POPULATOR_REGISTRY_CACHE.get();
    }
}