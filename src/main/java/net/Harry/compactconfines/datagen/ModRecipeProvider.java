package net.Harry.compactconfines.datagen;

import net.Harry.compactconfines.block.ModBlocks;
import net.Harry.compactconfines.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.IShapedRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPACT_COMPOUND_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.COMPACT_COMPOUND.get())
                .unlockedBy(getHasName(ModItems.COMPACT_COMPOUND.get()), has(ModItems.COMPACT_COMPOUND.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPACT_DUST_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.COMPACT_DUST.get())
                .unlockedBy(getHasName(ModItems.COMPACT_DUST.get()), has(ModItems.COMPACT_DUST.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_GEAR.get())
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COMPACT_COMPOUND_GEAR.get())
                .pattern(" # ")
                .pattern("#s#")
                .pattern(" # ")
                .define('#', ModItems.COMPACT_COMPOUND.get())
                .define('s', ModItems.STONE_GEAR.get())
                .unlockedBy(getHasName(ModItems.COMPACT_COMPOUND.get()), has(ModItems.COMPACT_COMPOUND.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COMPACT_COMPOUND.get(), 9)
                .requires(ModBlocks.COMPACT_COMPOUND_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPACT_COMPOUND_BLOCK.get()), has(ModBlocks.COMPACT_COMPOUND_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COMPACT_DUST.get(), 4)
                .requires(ModBlocks.COMPACT_DUST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPACT_DUST_BLOCK.get()), has(ModBlocks.COMPACT_DUST_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.OAK_PLANKS, 2)
                .requires(ModItems.BONSAI_LOG.get())
                .unlockedBy(getHasName(ModItems.BONSAI_LOG.get()), has(ModItems.BONSAI_LOG.get()))
                .save(pWriter);
    }
}
