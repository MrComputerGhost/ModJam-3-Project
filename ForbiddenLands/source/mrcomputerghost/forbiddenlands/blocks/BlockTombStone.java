package mrcomputerghost.forbiddenlands.blocks;

import java.util.Random;

import javax.swing.JOptionPane;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.ForbiddenLands;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import mrcomputerghost.forbiddenlands.util.ForbiddenUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTombStone extends BlockContainer {
	
	
	
	Random rand = new Random();

    protected BlockTombStone(int par1, Material par2Material)
    {
    	super(par1, Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityTombStone();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	TileEntityTombStone te = (TileEntityTombStone) world.getBlockTileEntity(i, j, k);	
    	ItemStack ebl = Minecraft.getMinecraft().thePlayer.getHeldItem();
    	if (ebl != null && ebl == new ItemStack(Item.skull)) {
    	String igh = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getTagCompound().getString("SkullOwner");
		
    	te.name = igh;
		return true;
    	} else return false;
    }

    @Override
    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer player)
    {
        TileEntityTombStone te = (TileEntityTombStone) world.getBlockTileEntity(i, j, k);
        te.name = "PROTOTYPE21_";
    	return;
    }

    public void dropItem(World world, double x, double y, double z, ItemStack stack)
    {
        EntityItem entityitem = new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, stack);
        entityitem.motionX = 0;
        entityitem.motionZ = 0;
        entityitem.motionY = 0.11000000298023224D;
        world.spawnEntityInWorld(entityitem);
    }

    public void breakBlock(World world, int i, int j, int k, int par5, int par6)
    {
        TileEntityTombStone te = (TileEntityTombStone) world.getBlockTileEntity(i, j, k);

        if (te != null)
        {
            world.markTileEntityForDespawn(te);
        }

        super.breakBlock(world, i, j, k, par5, par6);
    }

    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityLiving, ItemStack par6ItemStack)
    {
        int rotation = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        world.setBlockMetadataWithNotify(i, j, k, rotation, 2);
        TileEntityTombStone te = (TileEntityTombStone) world.getBlockTileEntity(i, j, k);
        te.name = "Skeleton";
    }

    @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
                this.blockIcon = par1IconRegister.registerIcon("forbiddenlands:grave");
    }
    public Block setTickRandomly(boolean par1)
    {
        this.needsRandomTick = par1;
        return this;
    }
    
    public boolean getTickRandomly()
    {
        return this.needsRandomTick;
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random par5Random) {
    	TileEntityTombStone te = (TileEntityTombStone) world.getBlockTileEntity(i, j, k);
    	
    }
        

}