package com.yuuki1293.chiselsbc.forge;

import net.minecraftforge.fml.common.Mod;

import com.yuuki1293.chiselsbc.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModForge {
    public ExampleModForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
