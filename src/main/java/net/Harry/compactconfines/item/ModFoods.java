package net.Harry.compactconfines.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BARK = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100), 0.7f).build();
}
