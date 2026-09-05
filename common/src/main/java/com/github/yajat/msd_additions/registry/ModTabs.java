package com.github.yajat.msd_additions.registry;

import com.github.yajat.msd_additions.MSDAdditions;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MSDAdditions.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MSD_ADDITIONS_TAB = TABS.register("msd_additions_tab", () ->
            CreativeTabRegistry.create(
                    Component.translatable("category.msd_additions"),     // tab title
                    () -> new ItemStack(ModBlocks.DIAMOND_CLUSTER.get())          // tab icon
            )); //Creative tab for the mod's items
    public static void register() {
        TABS.register();
    }
}