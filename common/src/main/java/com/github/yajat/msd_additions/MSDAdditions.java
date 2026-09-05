package com.github.yajat.msd_additions;

import com.github.yajat.msd_additions.registry.*;
import java.util.logging.Logger;

public final class MSDAdditions {
    public static final String MOD_ID = "msd_additions";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Is it registering? I'm not sure");
        ModBlocks.register();
        ModItems.register();
        ModFeatures.register();
        ModTabs.register();
    }
}
