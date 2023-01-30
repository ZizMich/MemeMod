package com.example.examplemod;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.items.wrapper.PlayerArmorInvWrapper;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ExampleMod.MODID)
    public class Events {
        @SubscribeEvent
        public static void fuck(LivingHurtEvent ev){
            Player player = ev.getEntity().level.getNearestPlayer(ev.getEntity(), 1);
            if(player!=null && ev.getSource()==DamageSource.FALL){
                for(ItemStack item:player.inventoryMenu.getItems()){
                    if(item.getItem().getClass()==Gainer.class){
                        player.setInvulnerable(true);
                        ev.getEntity().level.explode(null, player.getX(), player.getY()+2 , player.getZ(),2f, Explosion.BlockInteraction.NONE );
                        player.setInvulnerable(false);
                    }

                }
            }
        }

    }
        @Mod.EventBusSubscriber(modid = ExampleMod.MODID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
        public class Client {
            @SubscribeEvent
            public static void ent(EntityRenderersEvent.RegisterRenderers event) {
                event.registerEntityRenderer(ExampleMod.BULLET.get(), Jojo::new);
            }
        }
    }
