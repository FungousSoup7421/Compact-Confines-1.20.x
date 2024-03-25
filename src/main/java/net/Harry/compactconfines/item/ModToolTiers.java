package net.Harry.compactconfines.item;

import net.Harry.compactconfines.CompactConfines;
import net.Harry.compactconfines.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SCRAPPED = TierSortingRegistry.registerTier(
            new ForgeTier(3, 150, 2f, 4f, 5,
                    ModTags.Blocks.NEEDS_SCRAPPED_TOOL, () -> Ingredient.of(ModItems.COMPACT_COMPOUND.get())),
            new ResourceLocation(CompactConfines.MOD_ID, "compact_compound"), List.of(Tiers.STONE), List.of());
}
