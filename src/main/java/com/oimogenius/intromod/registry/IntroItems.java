package com.oimogenius.intromod.registry;

import com.oimogenius.intromod.IntroMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IntroItems {
    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IntroMod.MOD_ID);
    // アイテムを作成＆レジストリに登録
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties()));

    // レジストリをイベントバスに登録
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
