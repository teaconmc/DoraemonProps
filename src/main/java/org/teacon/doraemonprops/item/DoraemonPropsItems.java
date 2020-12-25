package org.teacon.doraemonprops.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.teacon.doraemonprops.DoraemonProps;

public final class DoraemonPropsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DoraemonProps.MOD_ID);

    public static RegistryObject<Item> BAMBOO_COPTER = ITEMS.register("bamboo_copter", BambooCopterItem::new);
}
