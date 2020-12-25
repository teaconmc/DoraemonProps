package org.teacon.doraemonprops;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.teacon.doraemonprops.item.DoraemonPropsItems;

@Mod(DoraemonProps.MOD_ID)
public class DoraemonProps {
    public static final String MOD_ID = "doraemon_props";

    public DoraemonProps() {
        DoraemonPropsItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
