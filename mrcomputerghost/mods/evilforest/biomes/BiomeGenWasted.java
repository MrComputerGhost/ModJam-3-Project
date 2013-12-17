package mrcomputerghost.mods.evilforest.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.monster.*;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenWasted extends BiomeGenBase
{
    public BiomeGenWasted(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = (byte)Block.tilledField.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 15, 1, 15));
    }

}
