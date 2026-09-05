package com.github.yajat.msd_additions.registry;

import com.github.yajat.msd_additions.MSDAdditions;
import com.github.yajat.msd_additions.block.custom.GrowingClusterBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    //Create a registry for blocks
    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(
                    MSDAdditions.MOD_ID,
                    Registries.BLOCK
            );

    //Allows for automated adds of block (and add them to the tab afterwards)
    private static RegistrySupplier<Block> registerBlock(String name,Supplier<Block> blockSupplier) {
        RegistrySupplier<Block> block =
                BLOCKS.register(
                        name,
                        blockSupplier);
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().arch$tab(ModTabs.MSD_ADDITIONS_TAB)));
        return block;
    }

    //List of added blocks (Block & BlockItem)
    public static final RegistrySupplier<Block> CRYSTAL_STONE = registerBlock("crystal_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> SHINING_STONE = registerBlock("shining_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).lightLevel(state -> 15)));

    //List of blocks with custom block classes
    public static final RegistrySupplier<Block> DIAMOND_CLUSTER = registerBlock("diamond_cluster",
            () -> new GrowingClusterBlock(7.0F,3.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).strength(3.0F).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> MEGA_CLUSTER = registerBlock("mega_cluster",
            () -> new GrowingClusterBlock(7.0F,3.0F, BlockBehaviour.Properties.of().strength(6.0F).randomTicks().requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> LARGE_MEGA_BUD = registerBlock("large_mega_bud",
            () -> new GrowingClusterBlock(5.0F,3.0F, BlockBehaviour.Properties.of().strength(5.0F).randomTicks()));

    public static final RegistrySupplier<Block> MEDIUM_MEGA_BUD = registerBlock("medium_mega_bud",
            () -> new GrowingClusterBlock(4.0F,3.0F, BlockBehaviour.Properties.of().strength(4.0F).randomTicks()));

    public static final RegistrySupplier<Block> SMALL_MEGA_BUD = registerBlock("small_mega_bud",
            () -> new GrowingClusterBlock(3.0F,4.0F, BlockBehaviour.Properties.ofFullCopy(Blocks.SMALL_AMETHYST_BUD).strength(3.0F).randomTicks()));

    public static void register() {
        BLOCKS.register();
    }
}