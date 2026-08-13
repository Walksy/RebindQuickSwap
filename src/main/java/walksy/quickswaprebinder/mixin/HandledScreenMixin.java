package walksy.quickswaprebinder.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import walksy.quickswaprebinder.RebindQuickSwapMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(value = AbstractContainerScreen.class, priority = 1500)
public abstract class HandledScreenMixin {
    @ModifyExpressionValue(
            method = "mouseClicked",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/input/MouseButtonEvent;hasShiftDown()Z"
            )
    )
    private boolean redirectClick(boolean original) {
        return original || RebindQuickSwapMod.shouldQuickSwap();
    }

    @ModifyExpressionValue(
            method = "mouseReleased",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/input/MouseButtonEvent;hasShiftDown()Z"
            )
    )
    private boolean redirectRelease(boolean original) {
        return original || RebindQuickSwapMod.shouldQuickSwap();
    }
}
