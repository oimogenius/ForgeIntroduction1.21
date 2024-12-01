package com.oimogenius.intromod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class RumItem extends Item {
    public RumItem(Properties pProperties) {
        super(pProperties);
    }

    // アイテムを使用する
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    // 使用した後の処理（エフェクトの追加、インベントリのアイテムの消費）
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        // エフェクトを追加
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));

        // アイテムの消費
        if (pLivingEntity instanceof Player player
                && !player.isCreative()) {
            // 使用者がプレイヤーかつ、クリエイティブモードではない場合、アイテムを１減らす
            pStack.shrink(1);
        }
        return pStack;
    }

    // アイテム使用にかかる時間の設定
    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 32;
    }

    // アニメーションの設定
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
