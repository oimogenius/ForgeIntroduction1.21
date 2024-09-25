package com.oimogenius.intromod.datagen.client;

import com.oimogenius.intromod.IntroMod;
import com.oimogenius.intromod.registry.IntroBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IntroBlockStateProvider extends BlockStateProvider {
    public IntroBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IntroMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(IntroBlocks.SALT_BLOCK);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
