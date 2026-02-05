package com.basil.machine;

import com.basil.machine.components.MinerBlockBaseComponent;
import com.basil.machine.components.MiningMachineComponent;
import com.basil.machine.components.ResourceNodeComponent;
import com.basil.machine.configs.ResourceConfig;
import com.basil.machine.systems.CheckForNodeSystem;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;

import javax.annotation.Nonnull;

public class Main extends JavaPlugin {
    private final Config<ResourceConfig> config = this.withConfig("Resource_config", ResourceConfig.CODEC);

    public Main(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        config.save();

        var registry = getEntityStoreRegistry();

        var ResourceNodeType = registry.registerComponent(
                ResourceNodeComponent.class,
                "ResourceNode",
                ResourceNodeComponent.CODEC
        );

        var MiningMachineType = registry.registerComponent(
                MiningMachineComponent.class,
                "MiningMachine",
                MiningMachineComponent.CODEC
        );

        ResourceNodeComponent.setComponentType(ResourceNodeType);
        MiningMachineComponent.setComponentType(MiningMachineType);

        registry.registerSystem(new CheckForNodeSystem(1.0f));
    }

}
