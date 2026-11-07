package com.fpsengine.mixin;

import com.fpsengine.FPSEngine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public abstract class ParticleEngineMixin {

    @Inject(method = "tickParticle", at = @At("HEAD"), cancellable = true, require = 0)
    private void fpsengine$throttleFarParticles(Particle particle, CallbackInfo ci) {
        try {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) return;
            Vec3 c = particle.getBoundingBox().getCenter();
            if (mc.player.distanceToSqr(c.x, c.y, c.z) > FPSEngine.PARTICLE_TICK_RADIUS_SQ) {
                ci.cancel();
            }
        } catch (Throwable ignored) {
            // never let the optimization crash the game
        }
    }
}
