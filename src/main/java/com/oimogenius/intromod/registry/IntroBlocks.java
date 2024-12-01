package com.oimogenius.intromod.registry;

import com.oimogenius.intromod.IntroMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class IntroBlocks {
    // レジストリを作成
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IntroMod.MOD_ID);
    // ブロックを作成＆レジストリに登録
    public static final RegistryObject<Block> SALT_BLOCK = registerBlockWithItem("salt_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.AMETHYST)));

    // ブロック＆アイテムを作成
    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> supplier) {
        // ブロックレジストリにブロックを登録
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        // アイテムレジストリにBlockItemを登録
        IntroItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // イベントバスに登録
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
