package io.github.blobanium.lt.mixin;

import io.github.blobanium.lt.LoadingTimer;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("HEAD"), method = "onResolutionChanged")
    private void onResolutionChanged(CallbackInfo info){
        if(LoadingTimer.isLoopActive){
        LoadingTimer.hasResolutionChanged = true;
        }
    }
}
