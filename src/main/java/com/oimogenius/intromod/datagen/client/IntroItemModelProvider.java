package com.oimogenius.intromod.datagen.client;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.registry.IntroItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IntroItemModelProvider extends ItemModelProvider {
    public IntroItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IntroMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(IntroItems.BUTTER.get());
        basicItem(IntroItems.SALT.get());
        basicItem(IntroItems.BUTTERED_POTATO.get());
        basicItem(IntroItems.RUM.get());
    }
}
