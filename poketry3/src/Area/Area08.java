package Area;

import _GameManager.MenuList;
import _GameManager._Main;

public class Area08 implements Area {
	/*프렌들리숍*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[포켓몬센터]==");
		map=new int[7][7];
		map=areaData.settingFence(map);
		/*set detail objects*/
		map[2][1]=-17;
		map[3][1]=-13;
		map[2][2]=-17;
		map[3][2]=-8;
		map[4][1]=-17;
		map[4][2]=-17;
		
		map[2][4]=-41;
		map[3][4]=-41;
		map[4][4]=-41;
		
		/*to GC*/
		map[0][3]=6;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 8;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 8;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to GC*/
		if(map[loc[0]][loc[1]]==6) {
			loc[0]=7;
			loc[1]=7;
			return 6;
		}
		return 8;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		if(npc==-8) Script.getInstance().scpt9();
	}

}
