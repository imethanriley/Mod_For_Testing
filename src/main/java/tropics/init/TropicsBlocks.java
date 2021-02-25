package tropics.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tropics.Tropics;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TropicsBlocks 
{
	public static Block dominus_ore;
	public static Block volcanic_block;
	
	@SubscribeEvent
	public static void RegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
			//Ore
			TropicsBlocks.dominus_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 6.0f).sound(SoundType.STONE)).setRegistryName(Tropics.location("dominus_ore")),
			
			//Blocks
			TropicsBlocks.volcanic_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 10.0f).sound(SoundType.METAL)).setRegistryName(Tropics.location("volcanic_block"))
		);		
		
		Tropics.LOGGER.info("Blocks registered");
	}
}
