package forge.learning.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModItems.firstDust, new ItemStack(ModItems.firstItem, 1), 1.5f);
		GameRegistry.addSmelting(ModBlocks.firstOre, new ItemStack(ModItems.firstDust, 1), 0.2f);
	}
}
