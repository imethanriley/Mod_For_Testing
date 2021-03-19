package tropics.entities.xtra.ai;

import net.minecraft.entity.ai.goal.Goal;
import tropics.entities.xtra.type.TropicsTinyBird;

import java.util.EnumSet;

import net.minecraft.entity.ai.goal.Goal.Flag;

public class TropicsBirdFly extends Goal {

	private TropicsTinyBird entity;

	public TropicsBirdFly(TropicsTinyBird bird) {
		this.entity = bird;
		this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
	}

	@Override
	public boolean canUse() {
		return !entity.isBirdLanded();
	}
}