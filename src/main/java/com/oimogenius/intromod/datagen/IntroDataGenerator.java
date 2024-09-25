package com.oimogenius.intromod.datagen;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.datagen.client.*;
import com.oimogenius.intromod.datagen.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = IntroMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IntroDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // アイテムモデル
        generator.addProvider(event.includeClient(), new IntroItemModelProvider(packOutput, existingFileHelper));
        // ブロックモデル
        generator.addProvider(event.includeClient(), new IntroBlockStateProvider(packOutput, existingFileHelper));
        // 言語ファイル
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        // サウンド
        generator.addProvider(event.includeClient(), new IntroSoundProvider(packOutput, existingFileHelper));

        // ブロックタグ
        IntroBlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(),
                new IntroBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        // アイテムタグ
        generator.addProvider(event.includeServer(),
                new IntroItemTagsProvider(packOutput, lookupProvider,
                        blockTagsProvider.contentsGetter(), existingFileHelper));
        // ルートテーブル
        generator.addProvider(event.includeServer(), IntroLootTables.create(packOutput, lookupProvider));
        // レシピ
        generator.addProvider(event.includeServer(), new IntroRecipeProvider(packOutput, lookupProvider));
        // 進捗
        generator.addProvider(event.includeServer(), new IntroAdvancementsProvider(packOutput, lookupProvider, existingFileHelper));
        // データパック
        generator.addProvider(event.includeServer(), new IntroDatapacksProvider(packOutput, lookupProvider));
        // GlobalLootModifier
        generator.addProvider(event.includeServer(),
                new IntroGlobalLootModifierProvider(packOutput, lookupProvider));
    }

}
