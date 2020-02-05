package forge.learning.init;

import forge.learning.Reference;
import forge.learning.items.ItemBasic;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	static Item firstItem;
	static Item firstDust;
	public static void init() {
		firstItem = new ItemBasic("first_item").setCreativeTab(CreativeTabs.MATERIALS);
		firstDust = new ItemBasic("first_dust").setCreativeTab(CreativeTabs.MATERIALS);
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(firstItem);
		event.getRegistry().registerAll(firstDust);
	}
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(firstItem);
		registerRender(firstDust);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
