package _GameManager;

import Bag.BagDAO;
import Han.DexDAO;
import Han.HanDAO;
import Poke.PokeDAO;

public class MenuList {
	
	private MenuList() {}
	static private MenuList instance=new MenuList();
	static public MenuList getInstance() {
		return instance;
	}
	
	public void showMenu() {
		while(true) {
			System.out.println("[1]도감\n[2]포켓몬\n[3]가방\n[4]한지우\n[5]저장\n[6]뒤로가기");
			int sel=_Main.s.nextInt();
			if(sel<1 || sel>6) continue;
			if(sel==1) {
				DexDAO.getInstance().showDex();
			}
			else if(sel==2) {
				PokeDAO.getInstance().showUserPkV2();
			}
			else if(sel==3) {
				BagDAO.getInstance().showBagMenuFloor();
			}
			else if(sel==4) {
				HanDAO.getInstance().hanInfo();
			}
			else if(sel==5) {
				
			}
			else break;
		}
	}

}
