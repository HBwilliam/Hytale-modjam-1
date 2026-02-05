package com.basil.machine.components;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nullable;

public class MiningMachineComponent extends MinerBlockBaseComponent{

    private static ComponentType<EntityStore, MiningMachineComponent> TYPE;

    public static void setComponentType(ComponentType<EntityStore, MiningMachineComponent> type) {
        TYPE = type;
    }

    public static ComponentType<EntityStore, MiningMachineComponent> getComponentType() {
        return TYPE;
    }

    public static final BuilderCodec<MiningMachineComponent> CODEC =BuilderCodec
            .builder(MiningMachineComponent.class, MiningMachineComponent::new)
            .append(
                    new KeyedCodec<>("Purity", Codec.STRING),
                    (component, value) -> component.purity = value,
                    component -> component.purity).add()
            .append(
                    new KeyedCodec<>("Resource", Codec.STRING),
                    (component, value) -> component.resource = value,
                    component -> component.resource).add()
            .build();

    public MiningMachineComponent() {}

    public MiningMachineComponent(String purity, String resource) {
        this.purity = purity;
        this.resource = resource;
    }

    @Nullable
    @Override
    public Component<EntityStore> clone() {
        return new MiningMachineComponent(purity, resource);
    }
}
