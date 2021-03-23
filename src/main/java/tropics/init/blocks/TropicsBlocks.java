package tropics.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tropics.Tropics;

import net.minecraft.block.AbstractBlock;

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
			dominus_ore = new DominusOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)).setRegistryName(Tropics.location("dominus_ore")),
			
			//Blocks
			volcanic_block = new Block(AbstractBlock.Properties.of(Material.METAL).strength(1.0f, 10.0f).sound(SoundType.METAL)).setRegistryName(Tropics.location("volcanic_block"))

		);
		
		Tropics.LOGGER.info("Blocks registered");
	}
}
