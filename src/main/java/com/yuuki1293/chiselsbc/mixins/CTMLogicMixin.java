package com.yuuki1293.chiselsbc.mixins;

import com.yuuki1293.chiselsbc.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.chisel.ctm.client.util.CTMLogic;

@Mixin(value = CTMLogic.class, remap = false)
public class CTMLogicMixin {
    @Inject(method = "isConnected(Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/block/state/IBlockState;)Z", at = @At("RETURN"), cancellable = true)
    private void isConnected(IBlockAccess world, BlockPos current, BlockPos connection, EnumFacing dir, IBlockState state, CallbackInfoReturnable<Boolean> cir) {
        boolean defaultRet = cir.getReturnValue();

        if (defaultRet) {
            boolean sameChunk = Utils.isSameChunk(current, connection);
            cir.setReturnValue(sameChunk); // false when different chunks
        }
    }
}
