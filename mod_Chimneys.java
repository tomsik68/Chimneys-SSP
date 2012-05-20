package net.minecraft.src;

public class mod_Chimneys extends BaseMod{
	private int lastType = 0;
	public static BlockChimney chimney;
	public static BlockChimney rsChimney;
	@Override
	public String getVersion() {
		return "0.1 for MC 1.1";
	}
	public void addChimneyType(Object kind){
		ModLoader.addRecipe(new ItemStack(chimney,4,lastType), new Object[]{"F","B","B",Character.valueOf('F'),Item.flint,Character.valueOf('B'),kind});
		ModLoader.addRecipe(new ItemStack(rsChimney,1,lastType), new Object[]{"C","R",Character.valueOf('C'),chimney,Character.valueOf('R'),Item.redstone});
		lastType += 1;
	}
	@Override
	public void load() {
		chimney = new BlockChimney(getUniqueBlockID(), false);
		rsChimney = new BlockChimney(getUniqueBlockID(), true);
		ModLoader.registerBlock(chimney);
		ModLoader.registerBlock(rsChimney);
		ModLoader.addName(chimney, "Chimney");
		ModLoader.addName(rsChimney, "Redstone Chimney");
		addChimneyType(Block.cobblestone);
		addChimneyType(Block.cobblestoneMossy);
		addChimneyType(Block.stone);
		addChimneyType(Block.stoneBrick);
		addChimneyType(Item.lightStoneDust);
		addChimneyType(Item.snowball);
		addChimneyType(Item.ingotGold);
		addChimneyType(Item.ingotIron);
		addChimneyType(Item.diamond);
		addChimneyType(Block.wood);
		addChimneyType(Block.planks);
		addChimneyType(Block.sand);
		addChimneyType(Block.sandStone);
		addChimneyType(Block.netherrack);
		addChimneyType(Block.brick);
	}
	private static int getUniqueBlockID(){
		for(int i = 5;i<Block.blocksList.length;i++){
			if(Block.blocksList[i] == null){
				System.out.println("Unique id: "+i);
				return i;
			}
		}
		return -1;
	}
	@Override
	public String getName() {
		return "Chimneys SSP";
	}
}
