package tropics.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tropics.TestMod;

import net.minecraft.block.AbstractBlock;
import tropics.init.blocks.ore.DominusOreBlock;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks
{
	public static final Block DOMINUS_ORE = new DominusOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)).setRegistryName(TestMod.location("dominus_ore"));
	public static final Block VOLCANIC_BLOCK = new Block(AbstractBlock.Properties.of(Material.METAL).strength(1.0f, 10.0f).sound(SoundType.METAL)).setRegistryName(TestMod.location("volcanic_block"));
	
	@SubscribeEvent
	public static void RegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
			//Ore
				DOMINUS_ORE,
			
			//Blocks
				VOLCANIC_BLOCK

		);
		
		TestMod.LOGGER.info("Blocks registered");
	}
}
