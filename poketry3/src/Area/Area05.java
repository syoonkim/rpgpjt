package Area;

import _GameManager.MenuList;
import _GameManager._Main;

public class Area05 implements Area {
	/*상록숲*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[상록숲]==");
		map=new int[10][10];
		int s1=map.length;
		int s2=map[0].length;
		/*set detail objects*/
		for(int i=0;i<s1;i++) {
			for(int j=0;j<s2;j++) {
				if(i==0 || i==s1-1 || j==0 || j==s2-1) map[i][j]=-21;
				else if(j==3 || j==6) map[i][j]=-21;
				else map[i][j]=10;
			}
		}

		map[7][3]=10;
		map[8][3]=10;
		map[1][6]=10;
		map[2][6]=10;
		
		
		/*to R1*/
		map[0][1]=4;
		
		/*to GC*/
		map[9][7]=6;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		
		if(sel>4 || sel<0) return 5;
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to R1*/
		if(map[loc[0]][loc[1]]==2) {
			loc[0]=4;
			loc[1]=8;
			return 4;
		}
		
		/*to GC*/
		if(map[loc[0]][loc[1]]==6) {
			loc[0]=1;
			loc[1]=1;
			return 6;
		}
		
		return 5;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		
	}
	

}
