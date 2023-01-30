package com.example.examplemod;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DRibose extends Item {
    public DRibose(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        if(!p_41433_.getCooldowns().isOnCooldown(this)){
            p_41433_.getCooldowns().addCooldown(this,40);
            p_41433_.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,3000,3,false,false));
            p_41433_.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,3000,2,false,false));
        }
        return super.use(p_41432_, p_41433_, p_41434_);
    }
}
