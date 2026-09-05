package com.github.yajat.msd_additions.registry;

import com.github.yajat.msd_additions.MSDAdditions;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.intellij.lang.annotations.Identifier;


public class ModItems {

    //Create a registry for items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(
                    MSDAdditions.MOD_ID,
                    Registries.ITEM
            );

    //Allows for automated adds of items
    private static RegistrySupplier<Item> registerItem(String name) {
        return ITEMS.register(
                name,
                () -> new Item(new Item.Properties().arch$tab(ModTabs.MSD_ADDITIONS_TAB)) //Made it so it automatically registers Blocks/Items onto the Mod's tab
        );
    }
    //List of added items
    public static final RegistrySupplier<Item> MEGA_SHARD = registerItem("mega_shard");
    public static void register () {
        ITEMS.register();
    }
}
