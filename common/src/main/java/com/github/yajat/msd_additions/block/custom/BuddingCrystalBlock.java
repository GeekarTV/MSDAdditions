//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.world.level.block;

import com.github.yajat.msd_additions.registry.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingCrystalBlock extends AmethystBlock {
    public static final MapCodec<BuddingAmethystBlock> CODEC = simpleCodec(BuddingAmethystBlock::new);
    public static final int GROWTH_CHANCE = 20;
    private static final Direction[] DIRECTIONS = Direction.values();

    public MapCodec<BuddingAmethystBlock> codec() {
        return CODEC;
    }

    public BuddingCrystalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(GROWTH_CHANCE) == 0) {
            Direction direction = DIRECTIONS[randomSource.nextInt(DIRECTIONS.length)];
            BlockPos blockPos2 = blockPos.relative(direction);
            BlockState blockState2 = serverLevel.getBlockState(blockPos2);
            Block block = null;
            if (canClusterGrowAtState(blockState2)) {
                block = ModBlocks.SMALL_MEGA_BUD.get();
            } else if (blockState2.is(ModBlocks.SMALL_MEGA_BUD.get()) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_MEGA_BUD.get();
            } else if (blockState2.is(ModBlocks.MEDIUM_MEGA_BUD.get()) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_MEGA_BUD.get();
            } else if (blockState2.is(ModBlocks.LARGE_MEGA_BUD.get()) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEGA_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockState3 = (BlockState)((BlockState)block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction)).setValue(AmethystClusterBlock.WATERLOGGED, blockState2.getFluidState().getType() == Fluids.WATER);
                serverLevel.setBlockAndUpdate(blockPos2, blockState3);
            }

        }
    }

    public static boolean canClusterGrowAtState(BlockState blockState) {
        return blockState.isAir() || blockState.is(Blocks.WATER) && blockState.getFluidState().getAmount() == 8;
    }
}
