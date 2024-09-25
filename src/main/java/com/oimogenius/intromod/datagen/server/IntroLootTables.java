package com.oimogenius.intromod.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class IntroLootTables {
    public static LootTableProvider create(PackOutput packOutput,
                                           CompletableFuture<HolderLookup.Provider> lookUpProvider) {
        return new LootTableProvider(packOutput, Set.of(), List.of(


        ), lookUpProvider);
    }
}
