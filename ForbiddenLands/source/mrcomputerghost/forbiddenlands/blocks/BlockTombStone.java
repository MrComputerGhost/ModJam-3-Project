package mrcomputerghost.forbiddenlands.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.ForbiddenLands;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTombStone extends BlockContainer {

        protected BlockTombStone(int id, boolean isLitten) {

                super(id, Material.wood);

                if (isLitten) {
                        setLightValue(1.0F);
                }

                if (!isLitten) {
                        setCreativeTab(ForbiddenLands.ForbiddenTab);
                }
        }

        public boolean onBlockActivated(Entity entity, World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        		if(player.inventory.getCurrentItem().itemID == ForbiddenItems.ParadoxStaff.itemID) {
        			world.setBlockToAir(x, y, z);
        			EntityZombie zombie = new EntityZombie(world);
        			world.spawnEntityInWorld(zombie);
        			if(!world.isRemote) {
        	            world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
        	        }
        			return true;
        		} else return false;
                
        }
        
        
        public TileEntity createNewTileEntity(World world) {

                return new TileEntityTombStone();
        }

        public int getRenderType() {

                return -1;
        }

        public boolean isOpaqueCube() {

                return false;
        }

        public boolean renderAsNormalBlock() {

                return false;
        }
        
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
                this.blockIcon = par1IconRegister.registerIcon("forbiddenlands:grave");
        }
        
        private void lightningStrike(World world, EntityPlayer player, int x, int y, int z) {
        		
            if(!world.isRemote) {
            world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
            }
        }

}