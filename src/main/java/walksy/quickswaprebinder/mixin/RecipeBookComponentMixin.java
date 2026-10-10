package walksy.quickswaprebinder.mixin;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.input.MouseButtonEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import walksy.quickswaprebinder.RebindQuickSwapMod;

@Mixin(value = RecipeBookComponent.class, priority = 1500)
public class RecipeBookComponentMixin {

    @Redirect(
            method = "mouseClicked",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/input/MouseButtonEvent;hasShiftDown()Z"
            )
    )
    private boolean redirectRecipeClick(MouseButtonEvent instance) {
        return RebindQuickSwapMod.shouldQuickSwap();
    }
}
