package net.Harry.compactconfines.item;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CompactConfines.MOD_ID);

    public static final RegistryObject<Item> COMPACT_CRYSTAL = ITEMS.register("compact_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPACT_COMPOUND = ITEMS.register("compact_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPACT_COMPOUND_GEAR = ITEMS.register("compact_compound_gear",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPACT_COMPOUND_PLATE = ITEMS.register("compact_compound_plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_GEAR = ITEMS.register("stone_gear",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPACT_DUST = ITEMS.register("compact_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BARK = ITEMS.register("bark",
            () -> new Item(new Item.Properties().food(ModFoods.BARK)));
    public static final RegistryObject<Item> BONSAI_LOG = ITEMS.register("bonsai_log",
            () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
