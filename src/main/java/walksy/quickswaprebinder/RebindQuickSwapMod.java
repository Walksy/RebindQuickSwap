package walksy.quickswaprebinder;

import com.mojang.blaze3d.platform.InputConstants;
import main.walksy.lib.api.config.value.WLKeyMapping;
import net.fabricmc.api.ModInitializer;

public class RebindQuickSwapMod implements ModInitializer {
    public static final WLKeyMapping KEY_BINDING = WLKeyMapping.create("Quick Swap Keybind", InputConstants.KEY_LSHIFT, "Rebind Quick Swap");

    @Override
    public void onInitialize() {
    }

    public static boolean shouldQuickSwap() {
        return KEY_BINDING.isHeld();
    }
}
