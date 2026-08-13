package walksy.quickswaprebinder.config;

import main.walksy.lib.api.WalksyLibConfig;
import main.walksy.lib.core.config.impl.ModConfig;
import main.walksy.lib.core.config.local.Category;
import main.walksy.lib.core.config.local.Option;
import main.walksy.lib.core.config.local.options.BooleanOption;
import main.walksy.lib.core.config.local.options.groups.OptionGroup;
import main.walksy.lib.core.utils.PathUtils;

public class Config implements WalksyLibConfig {

    @Override
    public ModConfig define() {
        return ModConfig.createBuilder()
            .path(PathUtils.ofConfigDir("rebindquickswap"))
            .build();
    }
}
