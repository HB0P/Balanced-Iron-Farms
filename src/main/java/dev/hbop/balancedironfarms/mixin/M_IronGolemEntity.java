package dev.hbop.balancedironfarms.mixin;

import dev.hbop.balancedironfarms.BalancedIronFarms;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(IronGolemEntity.class)
public abstract class M_IronGolemEntity extends GolemEntity {
    
    protected M_IronGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    public boolean isPushedByFluids() {
        if (BalancedIronFarms.CONFIG.golemsAreNotPushedByWater()) {
            return false;
        }
        return super.isPushedByFluids();
    }

    @Override
    public void setTarget(LivingEntity target) {
        if (BalancedIronFarms.CONFIG.golemsDoNotTargetPersistentEntities() && target instanceof MobEntity mob && mob.isPersistent()) {
            return;
        }
        super.setTarget(target);
    }
}