package com.github.yajat.msd_additions.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.ArrayList;
import java.util.List;

public class BuddingAmethystClustersFeature extends Feature<OreConfiguration> {
    public BuddingAmethystClustersFeature(Codec<OreConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        OreConfiguration config = context.config();
        int placed = 0;
        for (int i = 0; i < config.size; i++) {
            BlockPos pos = origin.offset(
                    random.nextInt(8) - 4,
                    random.nextInt(4) - 2,
                    random.nextInt(8) - 4
            );

            //First checks if the block can be replaced
            if (level.getBlockState(pos).is(Blocks.AMETHYST_BLOCK)) {
                level.setBlock(
                        pos,
                        Blocks.BUDDING_AMETHYST.defaultBlockState(),
                        2
                );
                placeClusters(level, pos, random);
                placed++;
            }
        }
        return placed > 0;
    }
    //Place random cluster levels (while checking if the block near the budding amethyst can be replaced)
    private void placeClusters(WorldGenLevel level, BlockPos pos, RandomSource random) {
        for (Direction direction : Direction.values()) {
            BlockPos clusterPos = pos.relative(direction);
            boolean isCluster = random.nextBoolean();
            Block[] Clusters = {Blocks.SMALL_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD, Blocks.LARGE_AMETHYST_BUD};
            int randomClust = (int) (random.nextInt(2));
            Block randomBlock = Clusters[randomClust];
            if (level.getBlockState(clusterPos).canBeReplaced() && isCluster) {
                    level.setBlock(
                            clusterPos,
                            randomBlock.defaultBlockState()
                                    .setValue(
                                            AmethystClusterBlock.FACING,
                                            direction
                                    ),
                            2
                    );
            }
        }
    }
}