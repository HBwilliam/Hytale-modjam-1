package com.basil.machine.configs;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class ResourceConfig {
    public static final BuilderCodec<ResourceConfig> CODEC = BuilderCodec.builder(ResourceConfig.class, ResourceConfig::new)
            .append(new KeyedCodec<>("Resources", new ArrayCodec<>(Codec.STRING, String[]::new)),
                    (config, value) -> config.resources = value,
                    config -> config.resources).add()
            .append(new KeyedCodec<>("PurityData", new ArrayCodec<>(PurityEntry.CODEC, PurityEntry[]::new)),
                    (config, value) -> config.purityData = value,
                    config -> config.purityData).add()
            .build();

    private String[] resources = {
            "Ore_Copper", "Ore_Iron", "Ore_Gold", "Ore_Cobalt",
            "Ore_Thorium", "Ore_Silver", "Ore_Adamantite"
    };

    private PurityEntry[] purityData = {
            new PurityEntry("LOW", 5.0, 1),
            new PurityEntry("NORMAL", 3.0, 2),
            new PurityEntry("HIGH", 1.5, 4)
    };

    public ResourceConfig() {}

    public String[] getResources() { return resources; }
    public void setResources(String[] resources) { this.resources = resources; }

    public PurityEntry[] getPurityData() { return purityData; }
    public void setPurityData(PurityEntry[] purityData) { this.purityData = purityData; }
}

