package net.Harry.compactconfines.block.entity;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CompactConfines.MOD_ID);

    public static final RegistryObject<BlockEntityType<AlloyerBlockEntity>> ALLOYER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("alloyer_block_entity", () ->
                    BlockEntityType.Builder.of(AlloyerBlockEntity::new,
                            ModBlocks.ALLOYER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
