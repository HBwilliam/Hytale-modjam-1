package com.basil.machine.systems;

import com.basil.machine.components.MiningMachineComponent;
import com.basil.machine.components.ResourceNodeComponent;
import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.DelayedEntitySystem;
import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.server.core.modules.entity.component.TransformComponent;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.logger.HytaleLogger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CheckForNodeSystem extends DelayedEntitySystem<EntityStore> {
    private static final HytaleLogger LOGGER = HytaleLogger.getLogger();
    public CheckForNodeSystem(float intervalSec) {
        super(1.0f);
    }

    @Nullable
    @Override
    public Query<EntityStore> getQuery() {
        return Query.and(MiningMachineComponent.getComponentType());
    }

    @Override
    public void tick(float v, int i, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        TransformComponent transComp = (TransformComponent) archetypeChunk.getComponent(i, TransformComponent.getComponentType());
        World world = store.getExternalData().getWorld();

        if (transComp == null) {LOGGER.atInfo().log("No Position"); return;}

        Vector3i minerPos = transComp.getPosition().toVector3i();
        Vector3i belowPos = minerPos.subtract(0, 1, 0) ;

        int blockBelowRef = world.getBlock(belowPos);
        LOGGER.atInfo().log("Miner at " + minerPos + " found block ID: " + blockBelowRef);
    }
}
