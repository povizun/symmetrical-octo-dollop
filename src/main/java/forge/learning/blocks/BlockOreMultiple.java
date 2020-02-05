package forge.learning.blocks;

import java.util.ArrayList;

import forge.learning.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockOreMultiple extends BlockBasic{
	public BlockOreMultiple(String name, Material material) {
		super(name, material);
	}

	@Override 
	public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune){
		ArrayList<ItemStack> drops=new ArrayList<ItemStack>() ;
		drops.add(new ItemStack(ModItems.firstDust, 1));
		if (RANDOM.nextFloat()>0.5f) {
			drops.add(new ItemStack(ModItems.firstItem,1));
		}
		return drops;
	}
}
