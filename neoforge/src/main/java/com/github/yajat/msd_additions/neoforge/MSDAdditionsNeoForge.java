package com.github.yajat.msd_additions.neoforge;

import com.github.yajat.msd_additions.MSDAdditions;
import net.neoforged.fml.common.Mod;

@Mod(MSDAdditions.MOD_ID)
public final class MSDAdditionsNeoForge {
    public MSDAdditionsNeoForge() {
        // Run our common setup.
        MSDAdditions.init();
    }
}
