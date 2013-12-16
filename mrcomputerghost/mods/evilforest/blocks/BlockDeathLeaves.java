package mrcomputerghost.mods.evilforest.blocks;

import java.util.Random;

import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockDeathLeaves extends Block
{

	public BlockDeathLeaves(int par1, String texture) 
    {
            super(par1, Material.wood);
            setCreativeTab(CreativeTabs.tabBlock);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
            return this.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }

    public void registerIcons(IconRegister reg) 
    {
            this.blockIcon = reg.registerIcon("ef:leaves_death"); 
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

            if (par5Random.nextInt(2) == 0)
            {
                    par1World.spawnParticle("smoke", par2 + par5Random.nextFloat(), par3 + 1.1F, par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
            }
    }

}