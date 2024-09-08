package com.oimogenius.intromod.registry;

import com.oimogenius.intromod.IntroMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class IntroTabs {
    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntroMod.MOD_ID);
    // タブを作成
    public static final RegistryObject<CreativeModeTab> INTRO_TAB =
            TABS.register("intro_tab", () -> CreativeModeTab.builder()
                    // タブのタイトルを設定
                    .title(Component.translatable("creativetabs.intro_tab"))
                    // タブのアイコンを設定
                    .icon(IntroItems.SALT.get()::getDefaultInstance)
                    // タブにアイテムを追加（必須）
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(IntroItems.SALT.get());
                        pOutput.accept(IntroItems.BUTTER.get());
                    })
                    // 検索バーを追加
                    .withSearchBar()
                    // 背景画像を設定
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(
                            IntroMod.MOD_ID, "textures/gui/introtab_bg.png"))
                    // ラベルの色を指定
                    .withLabelColor(Color.WHITE.getRGB())
                    // カーソルを当てたときのスロットの色を指定
                    .withSlotColor(new Color(0, 2, 116, 55).getRGB())
                    .build());

//    // ダミーのタブ
//    public static final RegistryObject<CreativeModeTab> DUMMY =
//            TABS.register("dummy", () -> CreativeModeTab.builder()
//                    .icon(Items.ARMOR_STAND::getDefaultInstance)
//                    .displayItems((pParameters, pOutput) -> {
//                        pOutput.accept(IntroItems.SALT.get());
//                        pOutput.accept(IntroItems.BUTTER.get());
//                    })
//                    // タブの順番を指定
//                    .withTabsAfter(CreativeModeTabs.BUILDING_BLOCKS)
//                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
