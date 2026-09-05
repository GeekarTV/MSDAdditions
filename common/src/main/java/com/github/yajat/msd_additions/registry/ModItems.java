package com.github.yajat.msd_additions.registry;

import com.github.yajat.msd_additions.MSDAdditions;
import com.github.yajat.msd_additions.item.custom.ShardBlockItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;


public class ModItems {

    //Create a registry for items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(
                    MSDAdditions.MOD_ID,
                    Registries.ITEM
            );

    //List of added items
    public static final RegistrySupplier<Item> MEGA_SHARD = ITEMS.register("mega_shard",
                    () -> new ShardBlockItem(ModBlocks.SMALL_MEGA_BUD.get(), new Item.Properties().arch$tab(ModTabs.MSD_ADDITIONS_TAB),"item.msd_additions.mega_shard"));

    public static void register () {
        ITEMS.register();
    }
}
