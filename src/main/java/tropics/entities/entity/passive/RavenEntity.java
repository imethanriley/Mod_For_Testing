package tropics.entities.entity.passive;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import tropics.entities.xtra.type.TropicsTinyBird;

public class RavenEntity extends TropicsTinyBird {
	
	public RavenEntity(EntityType<? extends RavenEntity> type, World world) {
		super(type, world);
		
		this.moveControl = new FlyingMovementController(this, 10, false);
	    this.setPathfindingMalus(PathNodeType.DANGER_FIRE, -1.0F);
	    this.setPathfindingMalus(PathNodeType.DAMAGE_FIRE, -1.0F);
	    this.setPathfindingMalus(PathNodeType.COCOA, -1.0F);
		
		this.maxUpStep = 1;
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.5F));
		//this.goalSelector.addGoal(2, new TropicsBirdFly(this));
		this.goalSelector.addGoal(2, new TemptGoal(this, 0.85F, true, SEEDS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0F));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3).add(Attributes.FLYING_SPEED, (double)0.4F).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }
	
	protected PathNavigator createNavigation(World worldIn) {
	    FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
	    flyingpathnavigator.setCanOpenDoors(false);
	    flyingpathnavigator.setCanFloat(true);
	    flyingpathnavigator.setCanPassDoors(true);
	    return flyingpathnavigator;
	}
	
	public boolean causeFallDamage(float distance, float damageMultiplier) {
	    return false;
	}

	    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}
	
	@Override
	public float getEyeHeight(Pose pose) {
		return this.getBbHeight() * 0.75F;
	}

	@Override
	public boolean isSpooked() {
		return this.hurtTime > 0;
	}
	
	public static boolean canSpawnHere(EntityType<? extends ShoulderRidingEntity> fish, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean isAllNeighborsSource = isSourceBlock(world, pos.north()) && isSourceBlock(world, pos.south()) && isSourceBlock(world, pos.west()) && isSourceBlock(world, pos.east());
        return isSourceBlock(world, pos) && isAllNeighborsSource;
    }

    private static boolean isSourceBlock(IWorld world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof FlowingFluidBlock && world.getFluidState(pos).is(FluidTags.WATER) && state.getValue(FlowingFluidBlock.LEVEL) == 0;
    }


}