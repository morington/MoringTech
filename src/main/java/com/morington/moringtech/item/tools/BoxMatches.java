package com.morington.moringtech.item.tools;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class BoxMatches extends Item {

    public BoxMatches(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if (!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockPos blockPos = context.getPos();
            Direction face = context.getFace();

            // 85% chance we'll set ourselves on fire
            if (random.nextFloat() > 0.85f) {
                entityOnFire(playerEntity, 1);
            } else {
                // Ignition of the block
                igniteBlock(context);// world, blockPos.offset(face), playerEntity);
            }

            // Deal damage to an object
            stack.damageItem(
                    1, playerEntity, player -> player.sendBreakAnimation(context.getHand())
            );
        }

        return super.onItemUseFirst(stack, context);
    }

    private void entityOnFire(Entity entity, int seconds) {
        entity.setFire(seconds);
    }

    private void igniteBlock(ItemUseContext context) {//World world, BlockPos pos, PlayerEntity playerEntity) {
        // BlockState targetState = world.getBlockState(pos);

        // Checking that the block can be set on fire
        // if (world.isAirBlock(pos) || targetState.getMaterial().isReplaceable()) {
        //     world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        // }

        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (CampfireBlock.canBeLit(blockstate)) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
            world.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
            if (playerentity != null) {
                context.getItem().damageItem(1, playerentity, (player) -> {
                    player.sendBreakAnimation(context.getHand());
                });
            }
        } else {
            BlockPos blockpos1 = blockpos.offset(context.getFace());
            if (AbstractFireBlock.canLightBlock(world, blockpos1, context.getPlacementHorizontalFacing())) {
                world.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                BlockState blockstate1 = AbstractFireBlock.getFireForPlacement(world, blockpos1);
                world.setBlockState(blockpos1, blockstate1, 11);
                ItemStack itemstack = context.getItem();
                if (playerentity instanceof ServerPlayerEntity) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
                    itemstack.damageItem(1, playerentity, (player) -> {
                        player.sendBreakAnimation(context.getHand());
                    });
                }
            }
        }
    }
}
