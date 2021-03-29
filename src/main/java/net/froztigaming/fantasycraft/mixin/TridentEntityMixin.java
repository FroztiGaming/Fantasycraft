package net.froztigaming.fantasycraft.mixin;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PersistentProjectileEntity.class)
public class TridentEntityMixin {
    @SuppressWarnings("cast")
    @Inject(method = "createSpawnPacket", at = @At("HEAD"))
    public void sendTridentStackOnSpawn(CallbackInfoReturnable<Packet<?>> info) {
        if (((Object) this) instanceof TridentEntity) {
            PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
            passedData.writeInt(Registry.ITEM.getRawId(((TridentEntity) (Object) this).tridentStack.getItem()));
            ServerPlayNetworking.send((ServerPlayerEntity) ((ServerPlayerEntity) (Object) this).world.getServer().getPlayerManager().getPlayerList(), ItemInit.id("triton_trident"), passedData);
        }
    }
}