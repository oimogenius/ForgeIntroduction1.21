package com.oimogenius.intromod.datagen.client;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.registry.IntroBlocks;
import com.oimogenius.intromod.registry.IntroItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, IntroMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(IntroItems.BUTTER, "バター");
        addItem(IntroItems.SALT, "塩");
        addItem(IntroItems.BUTTERED_POTATO, "じゃがバター");
        addItem(IntroItems.RUM, "ラム酒");

        add("creativetabs.intro_tab", "入門");

        addBlock(IntroBlocks.SALT_BLOCK, "塩ブロック");
    }
}
