package org.teacon.doraemonprops;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.teacon.doraemonprops.item.DoraemonPropsItems;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod(DoraemonProps.MOD_ID)
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class DoraemonProps {
    public static final String MOD_ID = "doraemon_props";

    public DoraemonProps() {
        DoraemonPropsItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
