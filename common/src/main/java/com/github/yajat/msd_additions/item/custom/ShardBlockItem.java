package com.github.yajat.msd_additions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ShardBlockItem extends BlockItem {

    private final String name;

    public ShardBlockItem(Block block, Properties properties, String name) {
        super(block, properties);
        this.name = name;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(name);
    }
}