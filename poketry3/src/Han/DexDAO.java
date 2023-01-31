package Han;

import java.util.ArrayList;

import Poke.Poke;

public class DexDAO {
	
	private DexDAO() {}
	static private DexDAO instance=new DexDAO();
	static public DexDAO getInstance() {
		return instance;
	}

	
	ArrayList<Dex> dxList=new ArrayList<Dex>();
	
	public void initDex() {
		dxList.add(new Dex(1,"이상해씨","풀","산에 서식하는 몬스터",false));
		dxList.add(new Dex(2,"이상해풀","풀","이상해씨가 진화한 몬스터",false));
		dxList.add(new Dex(3,"이상해꽃","풀","이상해풀이 진화한 몬스터",false));
		dxList.add(new Dex(4,"파이리","불","초원에 서식하는 몬스터",false));
		dxList.add(new Dex(5,"리자드","불","파이리가 진화한 몬스터",false));
		dxList.add(new Dex(6,"리자몽","불","리자드가 진화한 몬스터",false));
		dxList.add(new Dex(7,"꼬부기","물","물가에 서식하는 몬스터",false));
		dxList.add(new Dex(8,"어니부기","물","꼬부기가 진화한 몬스터",false));
		dxList.add(new Dex(9,"거북왕","물","어니부기가 진화한 몬스터",false));
		dxList.add(new Dex(10,"꼬렛","노말","새앙쥐를 닮은 몬스터",false));
		dxList.add(new Dex(11,"레트라","노말","꼬렛이 진화한 몬스터",false));
		dxList.add(new Dex(12,"구구","비행","비둘기를 닮은 몬스터",false));
		dxList.add(new Dex(13,"피죤","비행","구구가 진화한 몬스터",false));
		dxList.add(new Dex(14,"피죤투","비행","피죤이 진화한 몬스터",false));
		dxList.add(new Dex(15,"","","",false));
		dxList.add(new Dex(16,"","","",false));
		dxList.add(new Dex(17,"","","",false));
		dxList.add(new Dex(18,"","","",false));
		dxList.add(new Dex(19,"","","",false));
		dxList.add(new Dex(20,"","","",false));
		dxList.add(new Dex(21,"","","",false));
		dxList.add(new Dex(22,"","","",false));
		dxList.add(new Dex(23,"","","",false));
		dxList.add(new Dex(24,"","","",false));
		dxList.add(new Dex(25,"","","",false));
		dxList.add(new Dex(26,"","","",false));
	}
	
	public void showDex() {
		for(int i=0;i<dxList.size();i++) {
			if(dxList.get(i).isHave()==false) {
				System.out.println("("+dxList.get(i).getNum()+") ? ? ?");
			}
			else {
				System.out.println("("+dxList.get(i).getNum()+") "+dxList.get(i).getName()+"["+dxList.get(i).getType()+"] : "+dxList.get(i).getScript());
			}
		}
	}
	
	public void updateDex(int pknum) {
		pknum--;
		dxList.get(pknum).setHave(true);
	}
	
	public int findPokeNumByName(String pkName) {
		int idx=-1;
		for(int i=0;i<dxList.size();i++) {
			if(pkName.equals(dxList.get(i).getName())) idx=i;
		}
		return idx+1;
	}
	
}
