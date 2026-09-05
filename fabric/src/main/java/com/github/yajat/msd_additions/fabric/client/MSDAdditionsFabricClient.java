package com.github.yajat.msd_additions.fabric.client;

import com.github.yajat.msd_additions.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class MSDAdditionsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.MEGA_CLUSTER.get(),
                RenderType.cutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.DIAMOND_CLUSTER.get(),
                RenderType.cutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.SMALL_MEGA_BUD.get(),
                RenderType.cutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.MEDIUM_MEGA_BUD.get(),
                RenderType.cutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.LARGE_MEGA_BUD.get(),
                RenderType.cutout()
        );
    }
}
