package com.basil.machine.systems;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MachineMiningSystem extends EntityTickingSystem {
    @Override
    public void tick(float v, int i, @Nonnull ArchetypeChunk archetypeChunk, @Nonnull Store store, @Nonnull CommandBuffer commandBuffer) {

    }

    @Nullable
    @Override
    public Query getQuery() {
        return null;
    }
}
