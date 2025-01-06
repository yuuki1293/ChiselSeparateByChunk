package com.yuuki1293.chiselsbc.forge;

import com.yuuki1293.chiselsbc.ChiselSBC;
import earth.terrarium.athena.api.client.utils.AthenaUtils;
import net.minecraft.util.math.Direction;
import net.minecraftforge.fml.common.Mod;

@Mod(ChiselSBC.MOD_ID)
public class ChiselSBCForge {
    public ChiselSBCForge() {
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
