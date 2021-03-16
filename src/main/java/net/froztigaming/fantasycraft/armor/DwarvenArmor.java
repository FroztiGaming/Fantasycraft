package net.froztigaming.fantasycraft.armor;

import net.froztigaming.fantasycraft.register.Registration;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DwarvenArmor extends ArmorItem {

    public DwarvenArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    static boolean enablePerks = true;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && entity instanceof PlayerEntity && enablePerks)
        {
            PlayerEntity player = (PlayerEntity) entity;

            ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legs = player.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack feet = player.getEquippedStack(EquipmentSlot.FEET);

            if((head.getItem() == Registration.DWARVEN_HELMET &&
                    chest.getItem() == Registration.DWARVEN_CHESTPLATE &&
                    legs.getItem() == Registration.DWARVEN_LEGGINGS &&
                    feet.getItem() == Registration.DWARVEN_BOOTS))
            {
                ArmorEffects.giveHasteEffect(world, player);
                ArmorEffects.giveFireResistanceEffect(world, player);
                ArmorEffects.giveNightVisionEffect(world, player);
            }
        }
    }
}
