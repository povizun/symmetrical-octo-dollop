package forge.learning.init;

import forge.learning.Reference;
import forge.learning.blocks.BlockBasic;
import forge.learning.blocks.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {
	static Block firstBlock;
	public static Block firstOre;

	public static void init() {
		firstBlock = new BlockBasic("first_block", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(1.5f).setLightLevel(1.0f);
		firstBlock.setHarvestLevel("pickaxe", 2);
		firstOre = new BlockOre("first_ore", Material.ROCK, ModItems.firstDust).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(1.3f).setLightLevel(0.2f);
		firstOre.setHarvestLevel("pickaxe", 2);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(firstBlock);
		event.getRegistry().registerAll(firstOre);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(firstBlock).setRegistryName(firstBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(firstOre).setRegistryName(firstOre.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(firstBlock));
		registerRender(Item.getItemFromBlock(firstOre));
	}

	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}