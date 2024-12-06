package dev.hbop.balancedironfarms;

import io.wispforest.owo.config.annotation.Config;

@Config(name = BalancedIronFarms.MOD_ID, wrapperName = "ModConfig")
public class ModConfigModel {
    
    public boolean golemsAreNotPushedByWater = true;
    public boolean golemsDoNotTargetPersistentEntities = true;
}