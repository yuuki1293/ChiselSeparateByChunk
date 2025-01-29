package com.yuuki1293.chiselsbc;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

public class LateMixinLoader implements ILateMixinLoader {
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.chiselsbc.json");
    }
}
