package Area;

import Han.DexDAO;
import Poke.PokeDAO;
import _GameManager.EventDAO;
import _GameManager.MenuList;
import _GameManager._Main;

public class Area03 implements Area {
	/*연구소*/
	private AreaData areaData;
	int[][] map;
	
	@Override
	public void init(int[] loc) {
		areaData=AreaData.getInstance();
		System.out.println("==[연구소]==");
		map=new int[9][9];
		map=areaData.settingFence(map);
		/*set detail objects*/
		map[3][4]=-2;
		map[1][5]=EventDAO.getInstance().getterB();
		map[1][6]=EventDAO.getInstance().getterC();
		map[1][7]=EventDAO.getInstance().getterS();
		
		/*to TO*/
		map[8][4]=2;
	}

	@Override
	public int update(int[] loc) {
		printArea(loc);
		int npc=areaData.nextCellIsNpc(map, loc);
		
		int sel=_Main.s.nextInt();
		if(npc!=0) {
			if(sel>5 || sel<0) return 3;
			if(sel==5) script(npc);
		}
		else {
			if(sel>4 || sel<0) return 3;
		}
		if(sel==0) MenuList.getInstance().showMenu();
		loc=areaData.move(map, loc, sel);
		
		/*to TO*/
		if(map[loc[0]][loc[1]]==2) {
			if(EventDAO.getInstance().checkEvent02()==false) {
				System.out.println("[오박사] : 한지우? 이리로 와보거라.");
				loc[0]=7;
				loc[1]=4;
				return 3;
			}
			if(EventDAO.getInstance().checkEvent03()==false) {
				System.out.println("[오박사] : 이제 포켓몬을 선택해라.");
				loc[0]=7;
				loc[1]=4;
				return 3;
			}	
			
			loc[0]=3;
			loc[1]=7;
			return 2;
		}
		return 3;
	}

	@Override
	public void printArea(int[] loc) {
		areaData.printArea(map, loc);
	}

	@Override
	public void script(int npc) {
		if(npc==-2) {
			if(EventDAO.getInstance().checkEvent02()==false) {
				Script.getInstance().scpt2();
				EventDAO.getInstance().clearEvent02();
			}
			if(EventDAO.getInstance().checkEvent03()==false) {
				Script.getInstance().scpt6();
			}
			else if(EventDAO.getInstance().checkEvent03()==true) {
				Script.getInstance().scpt7();
			}
		}
		else {
			String ent="";
			int sel=0;
			if(EventDAO.getInstance().checkEvent02()==false) {
				System.out.println("[한지우] : 볼이군.");
			}
			else {
				if(npc==-14) {
					sel=Script.getInstance().scpt5();
					if(sel==1) {
						System.out.println("[이상해씨를 얻었다.]");
						EventDAO.getInstance().takeBur();
						PokeDAO.getInstance().addUserPk(PokeDAO.getInstance().strPk.get(0));
						DexDAO.getInstance().updateDex(1);
						map[1][5]=0;
					}
				}
				else if(npc==-15) {
					sel=Script.getInstance().scpt4();
					if(sel==1) {
						System.out.println("[파이리를 얻었다.]");
						EventDAO.getInstance().takeCha();
						PokeDAO.getInstance().addUserPk(PokeDAO.getInstance().strPk.get(1));
						DexDAO.getInstance().updateDex(4);
						map[1][6]=0;
					}
				}
				else if(npc==-16) {
					sel=Script.getInstance().scpt3();
					if(sel==2) {
						System.out.println("[꼬부기를 얻었다.]");
						EventDAO.getInstance().takeSqu();
						PokeDAO.getInstance().addUserPk(PokeDAO.getInstance().strPk.get(2));
						DexDAO.getInstance().updateDex(7);
						map[1][7]=0;
					}
				}
				EventDAO.getInstance().clearEvent01();
				EventDAO.getInstance().clearEvent03();
			}
		}
	}
	

}
