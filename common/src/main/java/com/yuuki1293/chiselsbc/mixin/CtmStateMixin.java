package com.yuuki1293.chiselsbc.mixin;

import com.yuuki1293.chiselsbc.api.Utils;
import earth.terrarium.athena.api.client.utils.AthenaUtils;
import earth.terrarium.athena.api.client.utils.CtmState;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = CtmState.class, remap = false)
public abstract class CtmStateMixin {
    @Unique
    private static boolean chiselsbc$enabled = false;
    @Unique
    private static BlockPos chiselsbc$blockPos = BlockPos.ORIGIN;
    @Unique
    private static Direction chiselsbc$direction = Direction.NORTH;

    @ModifyVariable(method = "from", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static BlockState from(BlockState value) {
        chiselsbc$enabled = true;
        return value;
    }

    @ModifyVariable(method = "from", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static BlockPos from(BlockPos value) {
        chiselsbc$blockPos = value;
        return value;
    }

    @ModifyVariable(method = "from", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static Direction from(Direction value) {
        chiselsbc$direction = value;
        return value;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 0)
    private static boolean modifyUp(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.UP) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 1)
    private static boolean modifyDown(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.DOWN) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 2)
    private static boolean modifyLeft(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.LEFT) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 3)
    private static boolean modifyRight(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.RIGHT) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 4)
    private static boolean modifyUpLeft(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.LEFT) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 5)
    private static boolean modifyUpRight(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.RIGHT) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 6)
    private static boolean modifyDownLeft(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.LEFT) : ctmState;
    }

    @ModifyVariable(method = "from", at = @At("STORE"), ordinal = 7)
    private static boolean modifyDownRight(boolean ctmState) {
        return chiselsbc$enabled && ctmState ? chiselsbc$check(AthenaUtils.UrMom.RIGHT) : ctmState;
    }

    /**
     * Check if separates are required.
     */
    @Unique
    private static boolean chiselsbc$check(AthenaUtils.UrMom urMom) {
        var direction = Utils.fromUrMom(chiselsbc$direction, urMom);
        return !Utils.isChunkBorder(chiselsbc$blockPos, direction);
    }
}
