package walksy.quickswaprebinder.config;

import main.walksy.lib.api.WalksyLibApi;
import main.walksy.lib.api.config.Config;
import main.walksy.lib.api.config.option.Category;
import main.walksy.lib.api.config.option.OptionGroup;
import main.walksy.lib.api.config.option.Options;
import main.walksy.lib.api.config.PathUtils;
import walksy.quickswaprebinder.RebindQuickSwapMod;

public final class RebindQuickSwapConfig implements WalksyLibApi {
    @Override
    public Config define() {
        return Config.builder()
            .path(PathUtils.ofConfigDir("rebindquickswap"))
            .category(Category.builder("General")
                .group(OptionGroup.builder("General")
                    .option(Options.ofKeybind("Quick Swap", RebindQuickSwapMod.KEY_BINDING).build())
                    .build())
                .build())
            .build();
    }
}
