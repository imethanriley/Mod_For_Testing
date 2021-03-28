package tropics.entities.entity.passive;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.JumpController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tropics.init.entity.ModEntities;

public class PoisonDartFrogEntity extends AnimalEntity {
	private static final DataParameter<Integer> DART_FROG_TYPE = EntityDataManager.defineId(PoisonDartFrogEntity.class, DataSerializers.INT);
	//private static final ResourceLocation RARE_FROG = new ResourceLocation("rare_dart_frog");
	private int jumpTicks;
	private int jumpDuration;
	private boolean wasOnGround;
	private int currentMoveTypeDuration;
	
	public PoisonDartFrogEntity(EntityType<? extends PoisonDartFrogEntity> entityIn, World world) {
	   super(entityIn, world);
	   this.jumpControl = new PoisonDartFrogEntity.JumpHelperController(this);
	   this.moveControl = new PoisonDartFrogEntity.MoveHelperController(this);
	   this.setMovementSpeed(0.0D);
	}
	
	protected void registerGoals() {
	   this.goalSelector.addGoal(1, new SwimGoal(this));
	   this.goalSelector.addGoal(1, new PoisonDartFrogEntity.PanicGoal(this, 2.2D));
	   this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
	   this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.CARROT, Items.GOLDEN_CARROT), false));
	   this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
	   this.goalSelector.addGoal(11, new LookAtGoal(this, PlayerEntity.class, 10.0F));
	}
	
	protected float getJumpPower() {
		if (!this.horizontalCollision && (!this.moveControl.hasWanted() || !(this.moveControl.getWantedY() > this.getY() + 0.5D))) {
			Path path = this.navigation.getPath();
			if (path != null && !path.isDone()) {
				Vector3d vector3d = path.getNextEntityPos(this);
			if (vector3d.y > this.getY() + 0.5D) {
				return 0.5F;
            }
       }
			return this.moveControl.getSpeedModifier() <= 0.6D ? 0.2F : 0.3F;
	   } else {
	        return 0.5F;
	   }
	}
	
	protected void jumpFromGround() {
		super.jumpFromGround();
	    Double d0 = this.moveControl.getSpeedModifier();
	    	if (d0 > 0.0D) {
	    		double d1 = getHorizontalDistanceSqr(this.getDeltaMovement());
	        if (d1 < 0.01D) {
	            this.moveRelative(0.1F, new Vector3d(0.0D, 0.0D, 1.0D));
	        }
	    }

	    if (!this.level.isClientSide) {
	    	this.level.broadcastEntityEvent(this, (byte)1);
	    }
	}
	
	public float getJumpCompletion(float p_175521_1_) {
		return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_175521_1_) / (float)this.jumpDuration;
	}

	public void setMovementSpeed(double newSpeed) {
	   this.getNavigation().setSpeedModifier(newSpeed);
	   this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), newSpeed);
	}

	public void setJumping(boolean jumping) {
	   super.setJumping(jumping);
	   if (jumping) {
	      this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
	   }

	}
	
	public void startJumping() {
	   this.setJumping(true);
	   this.jumpDuration = 10;
	   this.jumpTicks = 0;
	}
	
	protected void defineSynchedData() {
	   super.defineSynchedData();
	   this.entityData.define(DART_FROG_TYPE, 0);
	}
	
	public void customServerAiStep() {
	   if (this.currentMoveTypeDuration > 0) {
	      --this.currentMoveTypeDuration;
	   }

	   if (this.onGround) {
	      if (!this.wasOnGround) {
	         this.setJumping(false);
	         this.checkLandingDelay();
	      }


	      PoisonDartFrogEntity.JumpHelperController poisondartfrogentity$jumphelpercontroller = (PoisonDartFrogEntity.JumpHelperController)this.jumpControl;
	      if (!poisondartfrogentity$jumphelpercontroller.getIsJumping()) {
	         if (this.moveControl.hasWanted() && this.currentMoveTypeDuration == 0) {
	            Path path = this.navigation.getPath();
	            Vector3d vector3d = new Vector3d(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());
	            if (path != null && !path.isDone()) {
	               vector3d = path.getNextEntityPos(this);
	            }

	            this.calculateRotationYaw(vector3d.x, vector3d.z);
	            this.startJumping();
	         }
	      } else if (!poisondartfrogentity$jumphelpercontroller.canJump()) {
	         this.enableJumpControl();
	      }
	   }
	      this.wasOnGround = this.onGround;
	}
	
	public boolean canSpawnSprintParticle() {
	   return false;
	}
	
	private void calculateRotationYaw(double x, double z) {
	   this.yRot = (float)(MathHelper.atan2(z - this.getZ(), x - this.getX()) * (double)(180F / (float)Math.PI)) - 90.0F;
	}

	private void enableJumpControl() {
	   ((PoisonDartFrogEntity.JumpHelperController)this.jumpControl).setCanJump(true);
	}

	private void disableJumpControl() {
	   ((PoisonDartFrogEntity.JumpHelperController)this.jumpControl).setCanJump(false);
	}

	private void updateMoveTypeDuration() {
	   if (this.moveControl.getSpeedModifier() < 2.2D) {
	      this.currentMoveTypeDuration = 10;
	   } else {
	      this.currentMoveTypeDuration = 1;
	   }

	}

	private void checkLandingDelay() {
	   this.updateMoveTypeDuration();
	   this.disableJumpControl();
	}
	
	public void aiStep() {
	   super.aiStep();
	   if (this.jumpTicks != this.jumpDuration) {
	      ++this.jumpTicks;
	   } else if (this.jumpDuration != 0) {
	      this.jumpTicks = 0;
	      this.jumpDuration = 0;
	      this.setJumping(false);
	   }

	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
	   return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.FOLLOW_RANGE, getViewScale());
	}

	public void addAdditionalSaveData(CompoundNBT compound) {
	   super.addAdditionalSaveData(compound);
	   compound.putInt("DartFrogType", this.getDartFrogType());
	}
	
	public void readAdditionalSaveData(CompoundNBT compound) {
	   super.readAdditionalSaveData(compound);
	   this.setDartFrogType(compound.getInt("DartFrogType"));
	}
	
	protected SoundEvent getJumpSound() {
	   return SoundEvents.RABBIT_JUMP;
	}

	protected SoundEvent getAmbientSound() {
	   return SoundEvents.RABBIT_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	   return SoundEvents.RABBIT_HURT;
	}

	protected SoundEvent getDeathSound() {
	   return SoundEvents.RABBIT_DEATH;
	}
	
	private boolean isDartFrogBreedingItem(Item itemIn) {
	      return itemIn == Items.CARROT || itemIn == Items.GOLDEN_CARROT;
	}

	public PoisonDartFrogEntity getBreedOffspring(ServerWorld worldIn, AgeableEntity entity) {
		PoisonDartFrogEntity dartfrogentity = ModEntities.POISON_DART_FROG.create(worldIn);
	    int i = this.getRandomDartFrogType(worldIn);
	    if (this.random.nextInt(20) != 0) {
	    	if (entity instanceof PoisonDartFrogEntity && this.random.nextBoolean()) {
	    		//i = ((PoisonDartFrogEntity)entity).getDartFrogType();
	    		i = getRandomDartFrogType(worldIn);
	        } else {
	            //i = this.getDartFrogType();
	        	i = getRandomDartFrogType(worldIn);
	        }
	    }

	    dartfrogentity.setDartFrogType(i);
	  	return dartfrogentity;
	}
	
	public boolean isFood(ItemStack stack) {
		return this.isDartFrogBreedingItem(stack.getItem());
	}

	public int getDartFrogType() {
		return this.entityData.get(DART_FROG_TYPE);
	}
	
	public void setDartFrogType(int frogTypeId) {
		this.entityData.set(DART_FROG_TYPE, frogTypeId);
	}
	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		int i = this.getRandomDartFrogType(worldIn);
		if (spawnDataIn instanceof PoisonDartFrogEntity.PoisonDartFrogData) {
			i = ((PoisonDartFrogEntity.PoisonDartFrogData)spawnDataIn).typeData;
		} else {
			spawnDataIn = new PoisonDartFrogEntity.PoisonDartFrogData(i);
		}

		this.setDartFrogType(i);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	private int getRandomDartFrogType(IWorld world) {
		return this.random.nextInt(8);
	}
	
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
       if (id == 1) {
          this.spawnSprintParticle();
          this.jumpDuration = 10;
          this.jumpTicks = 0;
       } else {
          super.handleEntityEvent(id);
       }

    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashOffset() {
       return new Vector3d(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }
    
    public class JumpHelperController extends JumpController {
        private final PoisonDartFrogEntity frog;
        private boolean canJump;

        public JumpHelperController(PoisonDartFrogEntity frog) {
           super(frog);
           this.frog = frog;
        }

        public boolean getIsJumping() {
           return this.jump;
        }

        public boolean canJump() {
           return this.canJump;
        }

        public void setCanJump(boolean canJumpIn) {
           this.canJump = canJumpIn;
        }

        /**
         * Called to actually make the entity jump if isJumping is true.
         */
        public void tick() {
           if (this.jump) {
              this.frog.startJumping();
              this.jump = false;
           }

        }
     }
    
    static class MoveHelperController extends MovementController {
        private final PoisonDartFrogEntity frog;
        private double nextJumpSpeed;

        public MoveHelperController(PoisonDartFrogEntity frog) {
           super(frog);
           this.frog = frog;
        }

        public void tick() {
           if (this.frog.onGround && !this.frog.jumping && !((PoisonDartFrogEntity.JumpHelperController)this.frog.jumpControl).getIsJumping()) {
              this.frog.setMovementSpeed(0.0D);
           } else if (this.hasWanted()) {
              this.frog.setMovementSpeed(this.nextJumpSpeed);
           }

           super.tick();
        }

        /**
         * Sets the speed and location to move to
         */
        public void setWantedPosition(double x, double y, double z, double speedIn) {
           if (this.frog.isInWater()) {
              speedIn = 1.5D;
           }

           super.setWantedPosition(x, y, z, speedIn);
           if (speedIn > 0.0D) {
              this.nextJumpSpeed = speedIn;
           }

        }
     }
    
    static class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
        private final PoisonDartFrogEntity frog;

        public PanicGoal(PoisonDartFrogEntity frog, double speedIn) {
           super(frog, speedIn);
           this.frog = frog;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
           super.tick();
           this.frog.setMovementSpeed(this.speedModifier);
        }
     }
    
    public static class PoisonDartFrogData extends AgeableEntity.AgeableData {
        public final int typeData;

        public PoisonDartFrogData(int type) {
           super(1.0F);
           this.typeData = type;
        }
     }
}
