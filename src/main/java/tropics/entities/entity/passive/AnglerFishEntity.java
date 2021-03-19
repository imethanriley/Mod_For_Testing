package tropics.entities.entity.passive;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import tropics.Tropics;

public class AnglerFishEntity extends AbstractGroupFishEntity {
	public AnglerFishEntity(EntityType<? extends AnglerFishEntity> type, World worldIn) 
	{
		super(type, worldIn);
	}
	
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new RandomSwimmingGoal(this, 0.5d, 1));
		goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
		goalSelector.addGoal(2, new LookAtGoal(this, MobEntity.class, 8.0F));
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.COD_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.COD_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.COD_DEATH;
	}
	
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.COD_FLOP;
	}

	@Override
	protected ItemStack getBucketItemStack() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3);
    }
	
	@Override
	protected ResourceLocation getDefaultLootTable() {
		return Tropics.location("angler_fish");
	}
	 

    public static boolean canSpawnHere(EntityType<? extends AbstractFishEntity> fish, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean isAllNeighborsSource = isSourceBlock(world, pos.north()) && isSourceBlock(world, pos.south()) && isSourceBlock(world, pos.west()) && isSourceBlock(world, pos.east());
        return isSourceBlock(world, pos) && isAllNeighborsSource;
    }

    private static boolean isSourceBlock(IWorld world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof FlowingFluidBlock && world.getFluidState(pos).is(FluidTags.WATER) && state.getValue(FlowingFluidBlock.LEVEL) == 0;
    }
}
