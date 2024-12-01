package com.oimogenius.intromod.datagen.server;

import com.oimogenius.intromod.IntroMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class IntroGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public IntroGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, IntroMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {

    }
}
