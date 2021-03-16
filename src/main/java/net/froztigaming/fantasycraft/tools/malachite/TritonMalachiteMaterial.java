package net.froztigaming.fantasycraft.tools.malachite;

import net.froztigaming.fantasycraft.register.Registration;
import net.froztigaming.fantasycraft.tools.bronze.DwarvenBronzeMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TritonMalachiteMaterial implements ToolMaterial {

    public static final TritonMalachiteMaterial INSTANCE = new TritonMalachiteMaterial();

    @Override
    public int getDurability() {
        return 2000;
    }
    public float getMiningSpeedMultiplier() {
        return 9.0f;
    }
    public float getAttackDamage() {
        return 0.0f;
    }
    public int getMiningLevel() {
        return 3;
    }
    public int getEnchantability() {
        return 15;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Registration.MITHRIL_INGOT);
    }
}
