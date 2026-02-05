package com.basil.machine.components;

import com.basil.machine.configs.ResourceConfig;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nullable;

public class ResourceNodeComponent extends MinerBlockBaseComponent{

    private static ComponentType<EntityStore, ResourceNodeComponent> TYPE;

    public static void setComponentType(ComponentType<EntityStore, ResourceNodeComponent> type) {
        TYPE = type;
    }

    public static ComponentType<EntityStore, ResourceNodeComponent> getComponentType() {
        return TYPE;
    }

    public static final BuilderCodec <ResourceNodeComponent> CODEC =BuilderCodec
            .builder(ResourceNodeComponent.class, ResourceNodeComponent::new)
            .append(
                    new KeyedCodec<>("Purity", Codec.STRING),
                    (component, value) -> component.purity = value,
                    component -> component.purity).add()
            .append(
                    new KeyedCodec<>("Resource", Codec.STRING),
                    (component, value) -> component.resource = value,
                    component -> component.resource).add()
            .build();

    public ResourceNodeComponent() {}

    public ResourceNodeComponent(String purity, String resource) {
        this.purity = purity;
        this.resource = resource;
    }

    @Nullable
    @Override
    public Component<EntityStore> clone() {
        return new ResourceNodeComponent(purity, resource);
    }
}
