package com.github.yajat.msd_additions.worldgen;

import com.github.yajat.msd_additions.registry.ModBlocks;
import com.github.yajatkaul.mega_showdown.MegaShowdown;
import com.github.yajatkaul.mega_showdown.block.MegaShowdownBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class BuddingMegaClustersFeature extends Feature<OreConfiguration> {
    public BuddingMegaClustersFeature(Codec<OreConfiguration> codec) {
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
            if (level.getBlockState(pos).is(MegaShowdownBlocks.MEGA_METEOROID_BLOCK.get())) {
                level.setBlock(
                        pos,
                        MegaShowdownBlocks.MEGA_METEOROID_BLOCK.get().defaultBlockState(),
                        2
                );
                placeClusters(level, pos, random);
                placed++;
            }
        }
        return placed > 0;
    }
    //Place random cluster levels (while checking if the block near the budding amethyst can be replaced)
    public void placeClusters(WorldGenLevel level, BlockPos pos, RandomSource random) {
        for (Direction direction : Direction.values()) {
            BlockPos clusterPos = pos.relative(direction);
            boolean isCluster = random.nextBoolean();
            Block[] Clusters = {ModBlocks.SMALL_MEGA_BUD.get(), ModBlocks.MEDIUM_MEGA_BUD.get(), ModBlocks.LARGE_MEGA_BUD.get(), ModBlocks.MEGA_CLUSTER.get()};
            int randomClust = (int) (random.nextInt(3));
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