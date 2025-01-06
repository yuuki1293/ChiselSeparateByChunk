package com.yuuki1293.chiselsbc.api;

import earth.terrarium.athena.api.client.utils.AthenaUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

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

    /**
     * Get {@link Direction} from {@link AthenaUtils.UrMom}.
     */
    public static Direction fromUrMom(Direction facing, AthenaUtils.UrMom urMom) {
        return switch (facing) {
            case UP -> switch (urMom) {
                case UP -> Direction.NORTH;
                case DOWN -> Direction.SOUTH;
                case LEFT -> Direction.WEST;
                case RIGHT -> Direction.EAST;
            };
            case DOWN -> switch (urMom) {
                case UP -> Direction.SOUTH;
                case DOWN -> Direction.NORTH;
                case LEFT -> Direction.WEST;
                case RIGHT -> Direction.EAST;
            };
            case NORTH -> switch (urMom) {
                case UP -> Direction.UP;
                case DOWN -> Direction.DOWN;
                case LEFT -> Direction.EAST;
                case RIGHT -> Direction.WEST;
            };
            case SOUTH -> switch (urMom) {
                case UP -> Direction.UP;
                case DOWN -> Direction.DOWN;
                case LEFT -> Direction.WEST;
                case RIGHT -> Direction.EAST;
            };
            case WEST -> switch (urMom) {
                case UP -> Direction.UP;
                case DOWN -> Direction.DOWN;
                case LEFT -> Direction.NORTH;
                case RIGHT -> Direction.SOUTH;
            };
            case EAST -> switch (urMom) {
                case UP -> Direction.UP;
                case DOWN -> Direction.DOWN;
                case LEFT -> Direction.SOUTH;
                case RIGHT -> Direction.NORTH;
            };
        };
    }

}
