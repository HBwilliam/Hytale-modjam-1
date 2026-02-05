package com.basil.machine.components;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nullable;

public abstract class MinerBlockBaseComponent implements Component<EntityStore> {

    protected String purity;
    protected String resource;

    public Component<EntityStore> clone() {
        throw new UnsupportedOperationException("Clone base directly");
    }

    public String getPurity() {
        return purity;
    }

    public String getResource() {
        return resource;
    }
}
