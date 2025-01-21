package com.yuuki1293.chiselsbc;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class Utils {
    /**
     * Check block's {@code direction} side is chunk border.
     * @param pos block pos
     * @param direction block side
     */
    public static boolean isChunkBorder(BlockPos pos, Direction direction) {
        return switch (direction) {
            case NORTH -> Math.floorMod(pos.getZ(), 16) == 0;
            case SOUTH -> Math.floorMod(pos.getZ(), 16) == 15;
            case WEST -> Math.floorMod(pos.getX(), 16) == 0;
            case EAST -> Math.floorMod(pos.getX(), 16) == 15;
            default -> false; // UP & DOWN are ignored
        };
    }
}
