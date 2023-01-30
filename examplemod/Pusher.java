package com.example.examplemod;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class Pusher extends Item {
    public Pusher(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        p_41433_.setInvulnerable(true);
        p_41432_.explode(null, p_41433_.getX(), p_41433_.getY()+2 , p_41433_.getZ(),5f, Explosion.BlockInteraction.NONE );
        p_41433_.setInvulnerable(false);
        return super.use(p_41432_, p_41433_, p_41434_);
    }
}
