package tropics.init.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import tropics.Tropics;
import tropics.world.dimension.IslandsDimension;

public class DimensionOpenerItem extends Item {
	@ObjectHolder(Tropics.MOD_ID + ":" + "islands")
	public static final Item block = null;
	public DimensionOpenerItem() {
		super(new Item.Properties().group(Tropics.TROPICS).maxDamage(16));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			//int x = pos.getX();
			//int y = pos.getY();
			//int z = pos.getZ();
			if (world.isAirBlock(pos) && true)
				IslandsDimension.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
	
}
