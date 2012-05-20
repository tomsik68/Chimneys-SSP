package net.minecraft.src;

import java.util.Random;

public class BlockChimney extends Block {

	private final boolean rs;

	protected BlockChimney(int id, boolean rs) {
		super(id, 0, Material.rock);
		this.rs = rs;
		minX = 0.25;
		maxX = 0.75;
		minZ = minX;
		maxZ = maxX;
		maxY = 1;
		setHardness(2.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setRequiresSelfNotify();
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		switch (data) {
		case 0:
			return Block.cobblestone.getBlockTextureFromSide(side);
		case 1:
			return Block.cobblestoneMossy.getBlockTextureFromSide(side);
		case 2:
			return Block.stone.getBlockTextureFromSide(side);
		case 3:
			return Block.stoneBrick.getBlockTextureFromSide(side);
		case 4:
			return Block.glowStone.getBlockTextureFromSide(side);
		case 5:
			return Block.snow.getBlockTextureFromSide(side);
		case 6:
			return Block.blockGold.getBlockTextureFromSide(side);
		case 7:
			return Block.blockSteel.getBlockTextureFromSide(side);
		case 8:
			return Block.blockDiamond.getBlockTextureFromSide(side);
		case 9:
			return Block.wood.getBlockTextureFromSide(side);
		case 10:
			return Block.planks.getBlockTextureFromSide(side);
		case 11:
			return Block.sand.getBlockTextureFromSide(side);
		case 12:
			return Block.sandStone.getBlockTextureFromSide(side);
		case 13:
			return Block.netherrack.getBlockTextureFromSide(side);
		case 14:
			return Block.brick.getBlockTextureFromSide(side);
		}
		throw new IllegalArgumentException("Invalid chimney data: " + data);
	}

	@Override
	public int tickRate() {
		return 1;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		if (!rs
				|| (rs && (world.isBlockGettingPowered(x, y, z) || world
						.isBlockIndirectlyGettingPowered(x, y, z)))) {
			double yw = -0.029999999999999999D + random.nextGaussian() * 0.01D;
			for (int i = 0; i < 150; i++)
				world.spawnParticle("smoke", x + (maxX - minX), y + maxY + 0.3,
						z + (maxZ - minZ), 0, yw, 0);
		}

	}

	@Override
	public String getBlockName() {
		return rs ? "rsChimney" : "chimney";
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	protected int damageDropped(int i) {
		return i;
	}
	@Override
	public int idDropped(int i, Random random, int j) {
		return blockID;
	}
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLiving entityliving) {
		if (entityliving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityliving;
			world.setBlockMetadataWithNotify(i, j, k,player.getCurrentEquippedItem().getItemDamage());
		}
	}
}
