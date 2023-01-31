package Area;

import _GameManager.EventDAO;
import _GameManager.MenuList;
import _GameManager._Main;

public class Area06 implements Area {
	/*회색시티*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[회색시티]==");
		map=new int[15][15];
		map=areaData.settingFence(map);
		/*set detail objects*/
		if(EventDAO.getInstance().checkEvent06()==false) map[13][11]=-12;
		else if(EventDAO.getInstance().checkEvent06()==true) map[13][11]=0;
		
		/*to fst*/
		map[0][1]=5;
		
		/*to R2*/
		map[14][11]=11;
		
		/*Gym*/
		map[1][5]=-20;
		map[1][9]=-20;
		map[2][5]=-20;
		map[2][9]=-20;
		map[3][5]=-19;
		map[3][9]=-19;
		map[3][6]=-19;
		map[3][8]=-19;
		map[3][7]=9;
		for(int i=1;i<3;i++) {
			for(int j=6;j<9;j++) {
				map[i][j]=-39;
			}
		}
		
		/*pkmCt*/
		map[8][2]=-19;
		map[8][3]=7;
		map[8][4]=-19;
		map[9][2]=-20;
		map[10][2]=-20;
		map[11][2]=-19;
		map[11][3]=-19;
		map[11][4]=-19;
		map[10][4]=-20;
		map[9][4]=-20;
		map[9][3]=-37;
		map[10][3]=-37;
		
		/*shop*/
		map[8][6]=-19;
		map[8][7]=8;
		map[8][8]=-19;
		map[9][6]=-20;
		map[10][6]=-20;
		map[11][6]=-19;
		map[11][7]=-19;
		map[11][8]=-19;
		map[10][8]=-20;
		map[9][8]=-20;
		map[9][7]=-38;
		map[10][7]=-38;
		
		/*Museum*/
		map[5][11]=-20;
		map[5][12]=-19;
		map[5][13]=-19;
		map[6][11]=-20;
		map[7][11]=12;
		map[8][11]=-20;
		map[9][11]=-20;
		map[9][12]=-19;
		map[9][13]=-19;
		for(int i=6;i<9;i++) {
			for(int j=12;j<14;j++) {
				map[i][j]=-40;
			}
		}
		
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 6;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 6;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to fst*/
		if(map[loc[0]][loc[1]]==5) {
			loc[0]=8;
			loc[1]=7;
			return 5;
		}
		
		/*to pkmct*/
		if(map[loc[0]][loc[1]]==7) {
			loc[0]=1;
			loc[1]=3;
			return 7;
		}
		
		/*to shop*/
		if(map[loc[0]][loc[1]]==8) {
			loc[0]=1;
			loc[1]=3;
			return 8;
		}
		
		/*to gym*/
		if(map[loc[0]][loc[1]]==9) {
			loc[0]=5;
			loc[1]=3;
			return 9;
		}
		
		/*to museum*/
		if(map[loc[0]][loc[1]]==12) {
			loc[0]=1;
			loc[1]=1;
			return 12;
		}
		
		return 6;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		if(npc==-12) Script.getInstance().scpt14();
	}
	

}
