package com.github.yajat.msd_additions.block.custom;

import com.github.yajat.msd_additions.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GrowingClusterBlock extends AmethystClusterBlock {
    public GrowingClusterBlock(float f, float g, Properties properties) {
        super(f, g, properties); //Since it's like an Amethyst Cluster, I just took most of its properties
    }
    public static final int GROWTH_CHANCE = 20; //Chance of the cluster growing (will be configurable later on)


    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.randomTick(blockState, serverLevel, blockPos, randomSource);
        final Direction direction = blockState.getValue(FACING);
        final BlockPos blockPos2 = blockPos.relative(direction.getOpposite());

        // This checks first if the cluster has the chance to grow and then if the block the cluster is placed on is a crystal stone
        if (randomSource.nextInt(GROWTH_CHANCE) == 0 && serverLevel.getBlockState(blockPos2).getBlock() == ModBlocks.CRYSTAL_STONE.get()) {
            Block block = null;
            if (blockState.is(ModBlocks.SMALL_MEGA_BUD.get())) {
                block = ModBlocks.MEDIUM_MEGA_BUD.get();
            } else if (blockState.is(ModBlocks.MEDIUM_MEGA_BUD.get())) {
                block = ModBlocks.LARGE_MEGA_BUD.get();
            } else if (blockState.is(ModBlocks.LARGE_MEGA_BUD.get())) {
                block = ModBlocks.MEGA_CLUSTER.get();
            }

            // Then, based on all that, the cluster is set to grow and reuse the FACING property from the original cluster to be placed properly
            if (block != null) {
                BlockState blockStateFinal = (block.defaultBlockState()).setValue(FACING, blockState.getValue(FACING));
                serverLevel.setBlockAndUpdate(blockPos, blockStateFinal);
            }
        }

    }

}

