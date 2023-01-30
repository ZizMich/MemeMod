package com.example.examplemod;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.minecraft.world.entity.EntityType;

import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Bullet extends AbstractHurtingProjectile {

    public Vec3 movement;

    public boolean isOnFire() {
        return false;
    }
    private Float damage;
    public Bullet(EntityType<? extends AbstractHurtingProjectile> p_37364_, Level p_37365_) {
        super(p_37364_, p_37365_);
    }
//    public Bullet(Level p_37375_, LivingEntity p_37376_, double p_37377_, double p_37378_, double p_37379_) {
//        super(p_37375_, p_37376_, p_37377_, p_37378_, p_37379_);
//    }
//
//    public Bullet(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, double p_37371_, double p_37372_, double p_37373_) {
//        super(p_37367_, p_37368_, p_37369_, p_37370_, p_37371_, p_37372_, p_37373_);
//    }




    public void setDamage(Float damage){
        this.damage = damage;
    }
    @Override
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.SMOKE;
    }
    @Override
    public void tick() {
        if(tickCount>=400){this.discard();}
        if(this.movement!=null){
        setDeltaMovement(this.movement);
        }
        //else if(this.tickCount>=10){this.setDeltaMovement(new Vec3(0,-60,0));}
        super.tick();
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_) {
        super.onHitBlock(p_37258_);
    }
    @Override
    protected void onHitEntity(EntityHitResult p_37386_) {
        if(this.damage!=null){
        p_37386_.getEntity().hurt(DamageSource.IN_WALL,this.damage);}
        super.onHitEntity(p_37386_);
    }
}