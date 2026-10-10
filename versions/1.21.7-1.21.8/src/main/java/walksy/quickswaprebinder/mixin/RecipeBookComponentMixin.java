package walksy.quickswaprebinder.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import walksy.quickswaprebinder.RebindQuickSwapMod;

@Mixin(value = RecipeBookComponent.class, priority = 1500)
public class RecipeBookComponentMixin {
    @ModifyExpressionValue(
            method = "tryPlaceRecipe",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/Screen;hasShiftDown()Z"
            )
    )
    private boolean redirectRecipeClick(boolean original) {
        return original || RebindQuickSwapMod.shouldQuickSwap();
    }
}
