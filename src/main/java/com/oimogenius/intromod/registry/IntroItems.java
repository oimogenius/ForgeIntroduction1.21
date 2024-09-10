package com.oimogenius.intromod.registry;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.item.RumItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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
    // 食べ物
    public static final RegistryObject<Item> BUTTERED_POTATO = ITEMS.register("buttered_potato",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(6)   // 栄養
                            .saturationModifier(0.8f)   // 隠し満腹度
                            .fast() // 食べるスピードを早くする
                            .alwaysEdible() // 満腹でも食べられる
                            .effect(new MobEffectInstance(MobEffects.GLOWING, 600), 1.0f)
                    .build())));
    // 飲み物
    public static final RegistryObject<Item> RUM = ITEMS.register("rum",
            () -> new RumItem(new Item.Properties()));

    // レジストリをイベントバスに登録
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
