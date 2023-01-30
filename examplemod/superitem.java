package com.example.examplemod;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
public class superitem extends Item {
    public superitem(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if(!p_41405_.getNearestPlayer(p_41406_,1d).getCooldowns().isOnCooldown(this)) {
            if (p_41406_.isShiftKeyDown()) {
                p_41405_.addParticle(ParticleTypes.FLASH,p_41406_.getX(),p_41406_.getY()+2,p_41406_.getZ(),1d,1d,1d);
                p_41405_.getNearestPlayer(p_41406_,1d).getCooldowns().addCooldown(this,60);
                Vec3 g = p_41406_.getDeltaMovement().normalize().scale(2f);
                p_41406_.setDeltaMovement(g.x,g.y/5,g.z);
            }
        }
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }
//    @Override
//    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
//        Vec3 vec = p_41406_.getViewVector(0.5f);
//        SmallFireball ff  =new SmallFireball(p_41405_,p_41406_.getX(),p_41406_.getY(),p_41406_.getZ(),vec.x,vec.y,vec.z);
//        ff.setNoGravity(true);
//        ff.shoot(vec.x,vec.y,vec.z,40f,0.1f);
//        p_41405_.addFreshEntity(ff);
//        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
//    }
}
