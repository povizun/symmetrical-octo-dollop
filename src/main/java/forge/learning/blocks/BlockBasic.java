package forge.learning.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockBasic extends Block{
	public BlockBasic(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
