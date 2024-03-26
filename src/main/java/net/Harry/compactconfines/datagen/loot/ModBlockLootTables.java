package net.Harry.compactconfines.datagen.loot;

import net.Harry.compactconfines.block.ModBlocks;
import net.Harry.compactconfines.block.custom.BonsaiCropBlock;
import net.Harry.compactconfines.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.COMPACT_COMPOUND_BLOCK.get());
        this.dropSelf(ModBlocks.COMPACT_DUST_BLOCK.get());
        this.dropSelf(ModBlocks.COMPACT_LAMP.get());

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BONSAI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BonsaiCropBlock.AGE, 5));

        this.add(ModBlocks.BONSAI_CROP.get(), createCropDrops(ModBlocks.BONSAI_CROP.get(), ModItems.BONSAI_LOG.get(),
                ModItems.BONSAI_SEEDS.get(), lootitemcondition$builder));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}