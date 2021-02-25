package tropics.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tropics.init.TropicsBlocks;

public class TropicsItemGroup extends ItemGroup 
{
	public TropicsItemGroup() 
	{
		super("tropics");
	}

	public ItemStack createIcon() 
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(TropicsBlocks.dominus_ore));
	}

}
