package com.yuuki1293.chiselsbc;

import net.minecraft.util.math.BlockPos;

public class Utils {
    /**
     * Check block are same chunks.
     * @param pos1 block pos
     * @param pos2 block pos
     */
    public static boolean isSameChunk(BlockPos pos1, BlockPos pos2) {
        if (pos1 == null || pos2 == null) return false; // null check

        boolean diffChunkX = pos1.getX() >> 4 == pos2.getX() >> 4; // divine by 16
        boolean diffChunkZ = pos1.getZ() >> 4 == pos2.getZ() >> 4;

        return diffChunkX && diffChunkZ;
    }
}
