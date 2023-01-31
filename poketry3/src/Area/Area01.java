package Area;

import _GameManager.MenuList;
import _GameManager._Main;

public class Area01 implements Area {
	/*집*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[집]==");
		map=new int[6][6];
		map=areaData.settingFence(map);
		/*set detail objects*/
		map[2][3]=-1;
		map[5][2]=2;
		map[5][3]=2;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 1;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 1;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to TO*/
		if(map[loc[0]][loc[1]]==2) {
			loc[0]=4;
			loc[1]=2;
			return 2;
		}
		return 1;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	
	@Override
	public void script(int npc) {
		if(npc==-1) Script.getInstance().scpt1();
	}
	

}
