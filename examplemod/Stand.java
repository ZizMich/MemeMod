package com.example.examplemod;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Stand extends Item
{
    public Stand(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {

        if(!player.getCooldowns().isOnCooldown(this)) {
            player.getCooldowns().addCooldown(this,5);// Добовляем кул даун
            Vec3 vec = player.getViewVector(1f);// Вектор зрения игрока
            Float xv = player.getViewXRot(1f);
            Float yv = player.getViewYRot(1f);

            level.playSound(player,player.getOnPos(), SoundEvents.BLAZE_SHOOT, SoundSource.AMBIENT,1f,1f);// Звук выстрела
            level.addParticle(ParticleTypes.POOF,player.getX(),player.getY(),player.getZ(),0d,0d,0d);// Создание дымка после выстрела
        player.setDeltaMovement(new Vec3(-vec.x,-vec.y,-vec.z).scale(1.5d));// отбрасывание
        for(int i =0;i<30;i++){// цикл создания пуль
            Bullet bull = new Bullet(ExampleMod.BULLET.get(),level);//
            bull.setDamage(100f);// Создание сущности "пули"
            bull.setPos(player.getX(),player.getY()+1,player.getZ());//
            // переменная vec - Направление взгляда игрока.
            //bull.movement = vec.xRot(0.75f-i*0.05f).normalize();
            System.out.println(yv);
            if(yv<=90 & yv >=0){
                bull.movement = vec.yRot(0.75f-i*0.05f).xRot((0.75f-i*0.05f)*(-yv/90)*Math.abs(    xv)/90).zRot((0.75f-i*0.05f)*(1-yv/90)*Math.abs(    xv)/90).normalize();
            }
            else if(yv<0 & yv>-90 ){
                bull.movement = vec.yRot(0.75f-i*0.05f).xRot((0.75f-i*0.05f)*(-yv/90)*Math.abs(    xv)/90).zRot((0.75f-i*0.05f)*(1-Math.abs(yv/90))*Math.abs(    xv)/90).normalize();
            }
            else if(yv<=180 & yv>90){
                bull.movement = vec.yRot(0.75f-i*0.05f).zRot((0.75f-i*0.05f)*((yv-90)/90)*Math.abs( xv)/90).xRot((0.75f-i*0.05f)*(1-Math.abs((yv-90)/90))*Math.abs(    xv/90)).normalize();
            }
            else if(yv<-90 & yv>-180){
                bull.movement = vec.yRot(0.75f-i*0.05f).zRot((0.75f-i*0.05f)*((yv+90)/90)*Math.abs(    xv)/90).xRot((0.75f-i*0.05f)*(1-Math.abs((yv+90)/90))*Math.abs(    xv)/90).normalize();
            }

            level.addFreshEntity(bull);}}



        return super.use(level, player, p_41434_);


    }
}