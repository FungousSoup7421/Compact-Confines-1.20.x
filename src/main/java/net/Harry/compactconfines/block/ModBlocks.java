package net.Harry.compactconfines.block;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.block.custom.AlloyerBlock;
import net.Harry.compactconfines.block.custom.BonsaiCropBlock;
import net.Harry.compactconfines.block.custom.CompactLampBlock;
import net.Harry.compactconfines.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CompactConfines.MOD_ID);

    public static final RegistryObject<Block> COMPACT_COMPOUND_BLOCK = registerBlock("compact_compound_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK))));
    public static final RegistryObject<Block> COMPACT_DUST_BLOCK = registerBlock("compact_dust_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE_POWDER))));

    public static final RegistryObject<Block> COMPACT_LAMP = registerBlock("compact_lamp",
            () -> new CompactLampBlock((BlockBehaviour.Properties.copy(Blocks.REDSTONE_LAMP))));

    public static final RegistryObject<Block> BONSAI_CROP = BLOCKS.register("bonsai_crop",
            () -> new BonsaiCropBlock((BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission())));

    public static final RegistryObject<Block> ALLOYER = registerBlock("alloyer",
            () -> new AlloyerBlock(BlockBehaviour.Properties.copy(Blocks.GRINDSTONE).noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
