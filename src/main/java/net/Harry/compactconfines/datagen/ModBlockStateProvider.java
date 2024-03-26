package net.Harry.compactconfines.datagen;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.block.ModBlocks;
import net.Harry.compactconfines.block.custom.BonsaiCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CompactConfines.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COMPACT_COMPOUND_BLOCK);
        blockWithItem(ModBlocks.COMPACT_DUST_BLOCK);

        VariantBlockStateBuilder lampBlockState = getVariantBuilder(ModBlocks.COMPACT_LAMP.get());

        // Add the lit and unlit states
        lampBlockState.forAllStates(state -> {
            boolean lit = state.getValue(BlockStateProperties.LIT);
            String variant = lit ? "on" : "off";
            ModelFile model = models().cubeAll("compact_lamp_" + variant, modLoc("block/compact_lamp_" + variant));
            return ConfiguredModel.builder().modelFile(model).build();
        });

        // Register item model for the unlit lamp block
        ModelFile unlitItemModel = models().cubeAll("compact_lamp_off", modLoc("block/compact_lamp_off"));
        simpleBlockItem(ModBlocks.COMPACT_LAMP.get(), unlitItemModel);

        makeBonsaiCrop((CropBlock) ModBlocks.BONSAI_CROP.get(), "bonsai_stage", "bonsai_stage");
    }

    public void makeBonsaiCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> bonsaiStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] bonsaiStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BonsaiCropBlock) block).getAgeProperty()),
                new ResourceLocation(CompactConfines.MOD_ID, "block/" + textureName + state.getValue(((BonsaiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
