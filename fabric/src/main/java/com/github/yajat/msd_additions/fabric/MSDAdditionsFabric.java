package com.github.yajat.msd_additions.fabric;

import com.github.yajat.msd_additions.MSDAdditions;
import net.fabricmc.api.ModInitializer;

public final class MSDAdditionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        MSDAdditions.init();
    }
}
