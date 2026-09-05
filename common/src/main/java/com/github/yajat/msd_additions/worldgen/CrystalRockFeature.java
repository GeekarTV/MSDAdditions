package com.github.yajat.msd_additions.worldgen;

import com.github.yajat.msd_additions.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CrystalRockFeature extends Feature<NoneFeatureConfiguration> {
    public CrystalRockFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        for (int x = -2; x <= 2; x++) {
            for (int y = 0; y <= 2; ++y) {
                for (int z = 0; z <= 2; ++z) {
                    level.setBlock(origin.offset(x,y,z), ModBlocks.CRYSTAL_STONE.get().defaultBlockState(), 3);
                }
            }
        }
        return true;
    }
}
