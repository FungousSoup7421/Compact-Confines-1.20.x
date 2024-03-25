package net.Harry.compactconfines.item;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CompactConfines.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COMPACT_CONFINES_TAB = CREATIVE_MODE_TABS.register("compact_confines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COMPACT_COMPOUND.get()))
                    .title(Component.translatable("creativetab.compact_confines_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COMPACT_COMPOUND.get());
                        pOutput.accept(ModItems.COMPACT_CRYSTAL.get());
                        pOutput.accept(ModItems.COMPACT_COMPOUND_GEAR.get());
                        pOutput.accept(ModItems.COMPACT_COMPOUND_PLATE.get());
                        pOutput.accept(ModItems.STONE_GEAR.get());
                        pOutput.accept(ModItems.COMPACT_DUST.get());
                        pOutput.accept(ModItems.BARK.get());
                        pOutput.accept(ModItems.BONSAI_LOG.get());

                        pOutput.accept(ModItems.SCRAPPED_SWORD.get());
                        pOutput.accept(ModItems.SCRAPPED_PICKAXE.get());
                        pOutput.accept(ModItems.SCRAPPED_AXE.get());
                        pOutput.accept(ModItems.SCRAPPED_SHOVEL.get());
                        pOutput.accept(ModItems.SCRAPPED_HOE.get());

                        pOutput.accept(ModBlocks.COMPACT_COMPOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.COMPACT_DUST_BLOCK.get());

                        pOutput.accept(ModBlocks.COMPACT_LAMP.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
