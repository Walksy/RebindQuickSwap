package walksy.quickswaprebinder.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import walksy.quickswaprebinder.RebindQuickSwapMod;

@Mixin(value = AbstractContainerScreen.class, priority = 1500)
public abstract class HandledScreenMixin {
    @ModifyExpressionValue(
            method = "mouseReleased",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;hasShiftDown()Z"
            )
    )
    private boolean redirectRelease(boolean original) {
        return original || RebindQuickSwapMod.shouldQuickSwap();
    }
}
