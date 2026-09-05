package com.github.yajat.msd_additions.registry;

import com.github.yajat.msd_additions.MSDAdditions;
import com.github.yajat.msd_additions.worldgen.BuddingAmethystClustersFeature;
import com.github.yajat.msd_additions.worldgen.CrystalRockFeature;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(MSDAdditions.MOD_ID, Registries.FEATURE);

    //Currently added features
    public static final RegistrySupplier<Feature<OreConfiguration>> BUDDING_AMETHYST_CLUSTERS =
            FEATURES.register(
                    "budding_amethyst_clusters",
                    () -> new BuddingAmethystClustersFeature(OreConfiguration.CODEC)
            ); //Basically adds an amethyst cluster feature that only places on an amethyst block and replace the block into a budding amethyst
    public static final RegistrySupplier<Feature<NoneFeatureConfiguration>> CRYSTAL_ROCK =
            FEATURES.register(
                    "crystal_rock",
                    () -> new CrystalRockFeature(NoneFeatureConfiguration.CODEC)
            ); //Adds a rock linked to a root as a way to find the Crystal Caves
    public static void register () {
        FEATURES.register();
    }
}
