package com.yuuki1293.chiselsbc.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.supermartijn642.fusion.api.predicate.ConnectionDirection;
import com.supermartijn642.fusion.model.types.connecting.ConnectingBakedModel;
import com.yuuki1293.chiselsbc.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = ConnectingBakedModel.class, remap = false)
public abstract class ConnectingBakedModelMixin {
    @Inject(method = "shouldConnect", at = @At("RETURN"), cancellable = true)
    private static void shouldConnect(CallbackInfoReturnable<Boolean> cir, @Local BlockPos pos, @Local(argsOnly = true) Direction face, @Local(argsOnly = true) ConnectionDirection direction) {
        var dir = chiselSBC$fromCDirection(face, direction);
        var border = dir.stream()
            .anyMatch(d -> Utils.isChunkBorder(pos, d));

        if (border) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private static List<Direction> chiselSBC$fromCDirection(Direction facing, ConnectionDirection direction) {
        return switch (facing) {
            case UP -> switch (direction) {
                case TOP -> List.of(Direction.NORTH);
                case TOP_RIGHT -> List.of(Direction.NORTH, Direction.EAST);
                case RIGHT -> List.of(Direction.EAST);
                case BOTTOM_RIGHT -> List.of(Direction.SOUTH, Direction.EAST);
                case BOTTOM -> List.of(Direction.SOUTH);
                case BOTTOM_LEFT -> List.of(Direction.SOUTH, Direction.WEST);
                case LEFT -> List.of(Direction.WEST);
                case TOP_LEFT -> List.of(Direction.NORTH, Direction.WEST);
            };
            case DOWN -> switch (direction) {
                case TOP -> List.of(Direction.SOUTH);
                case TOP_RIGHT -> List.of(Direction.SOUTH, Direction.EAST);
                case RIGHT -> List.of(Direction.EAST);
                case BOTTOM_RIGHT -> List.of(Direction.NORTH, Direction.EAST);
                case BOTTOM -> List.of(Direction.NORTH);
                case BOTTOM_LEFT -> List.of(Direction.NORTH, Direction.WEST);
                case LEFT -> List.of(Direction.WEST);
                case TOP_LEFT -> List.of(Direction.SOUTH, Direction.WEST);
            };
            case NORTH -> switch (direction) {
                case TOP -> List.of(Direction.UP);
                case TOP_RIGHT -> List.of(Direction.UP, Direction.WEST);
                case RIGHT -> List.of(Direction.WEST);
                case BOTTOM_RIGHT -> List.of(Direction.DOWN, Direction.WEST);
                case BOTTOM -> List.of(Direction.DOWN);
                case BOTTOM_LEFT -> List.of(Direction.DOWN, Direction.EAST);
                case LEFT -> List.of(Direction.EAST);
                case TOP_LEFT -> List.of(Direction.UP, Direction.EAST);
            };
            case SOUTH -> switch (direction) {
                case TOP -> List.of(Direction.UP);
                case TOP_RIGHT -> List.of(Direction.UP, Direction.EAST);
                case RIGHT -> List.of(Direction.EAST);
                case BOTTOM_RIGHT -> List.of(Direction.DOWN, Direction.EAST);
                case BOTTOM -> List.of(Direction.DOWN);
                case BOTTOM_LEFT -> List.of(Direction.DOWN, Direction.WEST);
                case LEFT -> List.of(Direction.WEST);
                case TOP_LEFT -> List.of(Direction.UP, Direction.WEST);
            };
            case WEST -> switch (direction) {
                case TOP -> List.of(Direction.UP);
                case TOP_RIGHT -> List.of(Direction.UP, Direction.SOUTH);
                case RIGHT -> List.of(Direction.SOUTH);
                case BOTTOM_RIGHT -> List.of(Direction.DOWN, Direction.SOUTH);
                case BOTTOM -> List.of(Direction.DOWN);
                case BOTTOM_LEFT -> List.of(Direction.DOWN, Direction.NORTH);
                case LEFT -> List.of(Direction.NORTH);
                case TOP_LEFT -> List.of(Direction.UP, Direction.NORTH);
            };
            case EAST -> switch (direction) {
                case TOP -> List.of(Direction.UP);
                case TOP_RIGHT -> List.of(Direction.UP, Direction.NORTH);
                case RIGHT -> List.of(Direction.NORTH);
                case BOTTOM_RIGHT -> List.of(Direction.DOWN, Direction.NORTH);
                case BOTTOM -> List.of(Direction.DOWN);
                case BOTTOM_LEFT -> List.of(Direction.DOWN, Direction.SOUTH);
                case LEFT -> List.of(Direction.SOUTH);
                case TOP_LEFT -> List.of(Direction.UP, Direction.SOUTH);
            };
        };
    }
}
