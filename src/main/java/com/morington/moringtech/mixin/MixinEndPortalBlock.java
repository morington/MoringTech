package com.morington.moringtech.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndPortalBlock.class)
abstract class MixinEndPortalBlock {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(
            method = "entityInside",
            at = @At(value = "HEAD"),
            cancellable=true
    )
    public void runPortalEvent(BlockState state, World worldIn, BlockPos pos, Entity entityIn, CallbackInfo ci) {
        LOGGER.info("HELLO!");
        ci.cancel();
    }
}
