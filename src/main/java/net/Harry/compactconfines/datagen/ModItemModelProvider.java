package net.Harry.compactconfines.datagen;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CompactConfines.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COMPACT_COMPOUND);
        simpleItem(ModItems.COMPACT_DUST);
        simpleItem(ModItems.COMPACT_CRYSTAL);

        simpleItem(ModItems.STONE_GEAR);
        simpleItem(ModItems.COMPACT_COMPOUND_GEAR);
        simpleItem(ModItems.COMPACT_COMPOUND_PLATE);

        simpleItem(ModItems.BARK);
        simpleItem(ModItems.BONSAI_LOG);

        handheldItem(ModItems.SCRAPPED_SWORD);
        handheldItem(ModItems.SCRAPPED_PICKAXE);
        handheldItem(ModItems.SCRAPPED_AXE);
        handheldItem(ModItems.SCRAPPED_HOE);
        handheldItem(ModItems.SCRAPPED_SHOVEL);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CompactConfines.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CompactConfines.MOD_ID, "item/" + item.getId().getPath()));
    }
}
