package Area;

import Poke.PokeDAO;
import _GameManager.MenuList;
import _GameManager._Main;

public class Area04 implements Area {
	/*1번도로*/
	private AreaData areaData;
	int[][] map;

	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[1번도로]==");
		map=new int[10][10];
		map=areaData.settingFence(map);
		/*set detail objects*/

		/*bushes*/
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(i==1 || i==2) {
					if(j>0 && j<map[i].length-1) map[i][j]=10;
				}
				if(i>5 && i<map.length-1) {
					if(j>0 && j<6) map[i][j]=10;
				}
			}
		}
		
		/*to TO*/
		map[4][0]=2;
		
		/*to fst*/
		map[9][7]=5;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		
		if(sel>4 || sel<0) return 4;
		if(sel==0) MenuList.getInstance().showMenu();
		loc=move(map, loc, sel);
		
		/*to TO*/
		if(map[loc[0]][loc[1]]==2) {
			loc[0]=4;
			loc[1]=8;
			return 2;
		}
		
		/*to fst*/
		if(map[loc[0]][loc[1]]==5) {
			loc[0]=1;
			loc[1]=1;
			return 5;
		}
		
		return 4;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		
	}
	
	public int[] move(int[][] map, int[] loc, int sel) {
		int ny=loc[0];
		int nx=loc[1];
		
		if(sel==1) {
			ny--;
			if(map[ny][nx]>=0) {
				if(map[ny][nx]==10) {
					int prob=_Main.r.nextInt(7);
					if(prob==0 || prob==1) PokeDAO.getInstance().encR1(prob);
				}
				loc[0]--;
			}
		}
		if(sel==2) {
			ny++;
			if(map[ny][nx]>=0) {
				if(map[ny][nx]==10) {
					int prob=_Main.r.nextInt(7);
					if(prob==0 || prob==1) PokeDAO.getInstance().encR1(prob);
				}
				loc[0]++;
			}
		}
		if(sel==3) {
			nx--;
			if(map[ny][nx]>=0) {
				if(map[ny][nx]==10) {
					int prob=_Main.r.nextInt(7);
					if(prob==0 || prob==1) PokeDAO.getInstance().encR1(prob);
				}
				loc[1]--;
			}
		}
		if(sel==4) {
			nx++;
			if(map[ny][nx]>=0) {
				if(map[ny][nx]==10) {
					int prob=_Main.r.nextInt(7);
					if(prob==0 || prob==1) PokeDAO.getInstance().encR1(prob);
				}
				loc[1]++;
			}
		}
		return loc;
	}
	

}
