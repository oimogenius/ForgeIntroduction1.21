package com.oimogenius.intromod.datagen.client;

import com.oimogenius.intromod.IntroMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class IntroSoundProvider extends SoundDefinitionsProvider {
    public IntroSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, IntroMod.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
