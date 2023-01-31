package Area;

import java.util.ArrayList;

import Poke.Poke;
import Poke.PokeDAO;
import _GameManager.EventDAO;
import _GameManager.MenuList;
import _GameManager._Main;

public class Area09 implements Area {
	/*회색체육관*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[회색체육관]==");
		map=new int[7][7];
		map=areaData.settingFence(map);
		/*set detail objects*/
		for(int i=0;i<map.length;i++) {
			map[1][i]=-17;
		}
		map[1][3]=-11;
		map[3][1]=-9;
		map[4][5]=-10;
		
		map[3][3]=13;
		map[4][3]=14;
		
		map[5][1]=-17;
		map[5][5]=-17;
		map[2][5]=-17;
		
		
		/*to GC*/
		map[6][3]=6;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 9;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 9;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to GC*/
		if(map[loc[0]][loc[1]]==6) {
			loc[0]=4;
			loc[1]=7;
			return 6;
		}
		
		if(map[loc[0]][loc[1]]==13 && EventDAO.getInstance().checkEvent04()==false) {
			System.out.println("[웅이부하 1] 승부다. ▼");
			String ent=_Main.s.next();
			PokeDAO.getInstance().battleMob(1);
		}
		if(map[loc[0]][loc[1]]==14 && EventDAO.getInstance().checkEvent05()==false) {
			System.out.println("[웅이부하 2] 승부다. ▼");
			String ent=_Main.s.next();
			PokeDAO.getInstance().battleMob(2);
		}
		return 9;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		if(npc==-9) Script.getInstance().scpt10();
		if(npc==-10) Script.getInstance().scpt11();
		if(npc==-11) {
			if(EventDAO.getInstance().checkEvent06()==false) Script.getInstance().scpt12();
			else Script.getInstance().scpt13();
		}
	}

}
