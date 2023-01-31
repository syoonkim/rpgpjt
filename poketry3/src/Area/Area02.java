package Area;

import _GameManager.EventDAO;
import _GameManager.MenuList;
import _GameManager._Main;

public class Area02 implements Area {
	/*태초마을*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[태초마을]==");
		map=new int[10][10];
		map=areaData.settingFence(map);
		/*set detail objects*/
		for(int i=5;i<map.length;i++) {
			for(int j=5;j<map[i].length;j++) {
				if(i>5 && j>5) map[i][j]=-18;
				else map[i][j]=-17;
			}
		}
		
		/*town home*/
		map[3][1]=-19;
		map[3][2]=1;
		map[3][3]=-19;
		map[2][3]=-20;
		map[1][3]=-20;
		map[1][1]=-31;
		map[1][2]=-31;
		map[2][1]=-31;
		map[2][2]=-31;
		
		/*town lab*/
		map[1][6]=-20;
		map[2][6]=-19;
		map[2][8]=-19;
		map[1][7]=-33;
		map[1][8]=-33;
		map[2][7]=3;
		
		/*to route1*/
		map[4][9]=4;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 2;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 2;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to home*/
		if(map[loc[0]][loc[1]]==1) {
			loc[0]=4;
			loc[1]=2;
			return 1;
		}
		
		/*to lab*/
		if(map[loc[0]][loc[1]]==3) {
			loc[0]=7;
			loc[1]=4;
			return 3;
		}
		
		/*to route1*/
		if(map[loc[0]][loc[1]]==4) {
			if(EventDAO.getInstance().checkEvent01()) {
				loc[0]=4;loc[1]=1;
				return 4;
			}
			else {
				System.out.println("[보유한 포켓몬이 없어서 마을 밖으로 나갈 수 없다.]");
				loc[0]=4;loc[1]=8;
				return 2;
			}
		}
		return 2;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		// TODO Auto-generated method stub
	}
	


}
