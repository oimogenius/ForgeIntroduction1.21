package com.oimogenius.intromod.datagen.client;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.registry.IntroBlocks;
import com.oimogenius.intromod.registry.IntroItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, IntroMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(IntroItems.BUTTER, "Butter");
        addItem(IntroItems.SALT, "Salt");
        addItem(IntroItems.BUTTERED_POTATO, "Buttered Potato");
        addItem(IntroItems.RUM, "Rum");

        add("creativetabs.intro_tab", "Introduction");

        addBlock(IntroBlocks.SALT_BLOCK, "Salt Block");
    }
}
