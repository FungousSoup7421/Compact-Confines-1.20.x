package net.Harry.compactconfines.datagen;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.block.ModBlocks;
import net.Harry.compactconfines.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CompactConfines.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.NEEDS_SCRAPPED_TOOL)
                .add(ModBlocks.COMPACT_COMPOUND_BLOCK.get(),
                        ModBlocks.COMPACT_LAMP.get(),
                        ModBlocks.COMPACT_DUST_BLOCK.get(),
                        ModBlocks.COMPACT_COMPOUND_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPACT_COMPOUND_BLOCK.get(),
                        ModBlocks.COMPACT_LAMP.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COMPACT_DUST_BLOCK.get());
    }
}
