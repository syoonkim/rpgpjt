package Bag;

import java.util.ArrayList;

import Effect.Effect01;
import Effect.Effect02;
import Effect.Effect03;
import Han.DexDAO;
import Han.HanDAO;
import Item.Item01;
import Item.Item02;
import Item.Item03;
import Poke.Poke;
import Poke.PokeDAO;
import _GameManager._Main;

public class BagDAO {
	
	private BagDAO() {}
	static private BagDAO instance=new BagDAO();
	static public BagDAO getInstance() {
		return instance;
	}
	
	ArrayList<Bag01> itemList=new ArrayList<Bag01>();
	ArrayList<Bag02> ballList=new ArrayList<Bag02>();
	ArrayList<Bag01> ishop=new ArrayList<Bag01>();
	ArrayList<Bag02> bshop=new ArrayList<Bag02>();
	
	public void initBag() {
		itemList.add(new Item01("상처약",300,225,"[20의 HP를 회복하다.]",5,true,true,new Effect01()));
		itemList.add(new Item02("이상한사탕",4000,3000,"[몬스터의 레벨을 1 올리다.]",99,true,false,new Effect02()));
		ballList.add(new Bag02(1,"몬스터볼",200,150,"[낮은 확률로 몬스터를 포획하다.]",10,1,false,true));
		
		ishop.add(new Item01("상처약",300,225,"[20의 HP를 회복하다.]",1,true,true,new Effect01()));
		ishop.add(new Item03("좋은상처약",500,325,"[50의 HP를 회복하다.]",1,true,true,new Effect03()));
		
		bshop.add(new Bag02(1,"몬스터볼",200,150,"[낮은 확률로 몬스터를 포획하다.]",1,1,false,true));
		bshop.add(new Bag02(2,"슈퍼볼",500,325,"[제법 괜찮은 확률로 몬스터를 포획하다.]",1,1,false,true));
	}
	
	/*맨땅 가방 체크*/
	
	public void showBagMenuFloor() {
		while(true) {
			System.out.println("[1]소비\n[2]볼\n[3]뒤로가기");
			int sel=_Main.s.nextInt();
			if(sel<1 || sel>3) continue;
			if(sel==1) {
				showItemListFloor();
			}
			else if(sel==2) {
				showBallListFloor();
			}
			else if(sel==3) {
				break;
			}
		}
		return;
	}
	
	public void showItemListFloor() {
		int sel=-1;
		while(true) {
			System.out.println("----[소비템]----");
			int length=itemList.size();
			for(int i=0;i<length;i++) {
				if(itemList.get(i).getUseCnt()!=0) System.out.println((i+1)+") ["+itemList.get(i).getUseName()+"]\t x"+itemList.get(i).getUseCnt());
			}
			System.out.println("--------------");
			System.out.println("[1]아이템 선택 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("아이템 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>itemList.size()) continue;
				else break;
			}
			oneItemInfoFloor(idx);
		}
		return;
	}
	
	public void oneItemInfoFloor(int idx) {
		int sel=-1;
		System.out.println("["+itemList.get(idx).getUseName()+"] : "+itemList.get(idx).getUseScript());
		while(true) {
			System.out.println("[1]사용하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) useItemFloor(itemList.get(idx));
		return;
	}
	
	public void useItemFloor(Bag01 item) {
		if(item.isField()==false) {
			System.out.println("[지금은 사용할 수 없다.] ▼");
			String ent=_Main.s.next();
			return;
		}
		else {
			int sel=-1;
			while(true) {
				PokeDAO.getInstance().showUserPk();
				System.out.println("[누구에게 쓸 지 지정하다.] ▼");
				sel=_Main.s.nextInt();
				if(sel<1 || sel>PokeDAO.getInstance().userPkLength()) continue;
				else break;
			}
			sel--;
			item.getEffect().effect(PokeDAO.getInstance().getOneUserPk(sel));
			return;
		}
	}
	
	public void showBallListFloor() {
		int sel=-1;
		while(true) {
			System.out.println("----[볼]----");
			int length=ballList.size();
			for(int i=0;i<length;i++) {
				if(ballList.get(i).getBallCnt()!=0) System.out.println((i+1)+") ["+ballList.get(i).getBallName()+"]\t x"+ballList.get(i).getBallCnt());
			}
			System.out.println("--------------");
			System.out.println("[1]볼 선택 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("볼 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>ballList.size()) continue;
				else break;
			}
			oneBallInfoFloor(idx);
		}
		return;
	}
	
	public void oneBallInfoFloor(int idx) {
		int sel=-1;
		System.out.println("["+ballList.get(idx).getBallName()+"] : "+ballList.get(idx).getBallScript());
		while(true) {
			System.out.println("[1]사용하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			System.out.println("[지금은 사용할 수 없다.] ▼");
			String ent=_Main.s.next();
		}
		return;
	}
	
	/*전투 중 가방 체크*/
	
	public void showBagMenuBattle(Poke sub, Poke obj, int npc) {
		int sel=-1;
		while(true) {
			System.out.println("[1]소비\n[2]볼\n[3]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>3) continue;
			else break;
		}
			
		if(sel==1) showItemListBattle(sub);
		else if(sel==2) {
			if(npc==0) showBallListBattle(obj);
			else System.out.println("[상대방의 소중한 몬스터를 앗아갈 수 없다.] ▼");
			String ent=_Main.s.next();
		}
		return;
	}
	
	public void showItemListBattle(Poke sub) {
		int sel=-1;
		while(true) {
			System.out.println("----[소비템]----");
			int length=itemList.size();
			for(int i=0;i<length;i++) {
				if(itemList.get(i).getUseCnt()!=0) System.out.println((i+1)+") ["+itemList.get(i).getUseName()+"]\t x"+itemList.get(i).getUseCnt());
			}
			System.out.println("--------------");
			System.out.println("[1]아이템 선택 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("아이템 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>itemList.size()) continue;
				else break;
			}
			oneItemInfoBattle(idx,sub);
		}
		return;
		
	}
	
	public void oneItemInfoBattle(int idx, Poke sub) {
		int sel=-1;
		System.out.println("["+itemList.get(idx).getUseName()+"] : "+itemList.get(idx).getUseScript());
		while(true) {
			System.out.println("[1]사용하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) useItemBattle(itemList.get(idx),sub);
		return;
	}
	
	public void useItemBattle(Bag01 item, Poke sub) {
		if(item.isBattle()==false) {
			System.out.println("[전투중엔 사용할 수 없다.] ▼");
			String ent=_Main.s.next();
			return;
		}
		else {
			item.getEffect().effect(sub);
			return;
		}
	}
	
	public void showBallListBattle(Poke obj) {
		int sel=-1;
		while(true) {
			System.out.println("----[볼]----");
			int length=ballList.size();
			for(int i=0;i<length;i++) {
				if(ballList.get(i).getBallCnt()!=0) System.out.println((i+1)+") ["+ballList.get(i).getBallName()+"]\t x"+ballList.get(i).getBallCnt());
			}
			System.out.println("--------------");
			System.out.println("[1]볼 선택 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("볼 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>ballList.size()) continue;
				else break;
			}
			oneBallInfoBattle(idx,obj);
		}
		return;
	}
	
	public void oneBallInfoBattle(int idx, Poke obj) {
		int sel=-1;
		System.out.println("["+ballList.get(idx).getBallName()+"] : "+ballList.get(idx).getBallScript());
		while(true) {
			System.out.println("[1]사용하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) useBallBattle(ballList.get(idx),obj);
		return;
	}
	
	public void useBallBattle(Bag02 ball, Poke obj) {
		ball.setBallCnt(ball.getBallCnt()-1);
		int cprob=_Main.r.nextInt(5-ball.getBallRate());
		
		double ratio=obj.getCurHp()/(double)obj.getMaxHp();
		if(ratio<0.6) cprob--;
		else if(ratio<0.3) cprob-=2;
		
		if(cprob==0) {
			System.out.println("[야호."+obj.getName()+"을(를) 잡았다.] ▼");
			String ent=_Main.s.next();
			PokeDAO.getInstance().addUserPk(obj);
			int num=DexDAO.getInstance().findPokeNumByName(obj.getName());
			DexDAO.getInstance().updateDex(num);
			obj.setStatus("잡힘");
		}
		else {
			System.out.println("[이런. "+obj.getName()+"이(가) 볼을 깨고 튀어나왔다.] ▼");
			String ent=_Main.s.next();
		}
	}
	
	/*상점*/
	
	public void showIshop() {
		int sel=-1;
		while(true) {
			System.out.println("----[소비템]----");
			int length=ishop.size();
			for(int i=0;i<length;i++) {
				System.out.println((i+1)+") ["+ishop.get(i).getUseName()+"]\t "+ishop.get(i).getUseBuyPrice()+"원");
			}
			System.out.println("--------------");
			System.out.println("[1]아이템 구매 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
		
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("아이템 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>ishop.size()) continue;
				else break;
			}
			oneItemInfoShop(idx);
		}
		return;
	}
	
	public void oneItemInfoShop(int idx) {
		int sel=-1;
		System.out.println("["+ishop.get(idx).getUseName()+"] : "+ishop.get(idx).getUseScript());
		while(true) {
			System.out.println("[1]구매하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) buyItem(idx);
		return;
	}
	
	public void buyItem(int idx) {
		if(HanDAO.getInstance().showMoney()<ishop.get(idx).getUseBuyPrice()) {
			System.out.println("[돈이 부족하다.]");
			String ent=_Main.s.next();
			return;
		}
		
		int checker=-1;
		String iname=ishop.get(idx).getUseName();
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).getUseName().equals(iname)) {
				checker=1;
				itemList.get(i).setUseCnt(itemList.get(i).getUseCnt()+1);
			}
		}
		if(checker!=1) itemList.add(ishop.get(idx));
		HanDAO.getInstance().updateMoney((ishop.get(idx).getUseBuyPrice())*-1);
		System.out.println("[점원] : 구매완료. ▼");
		String ent=_Main.s.next();
	}
	
	public void showBshop() {
		int sel=-1;
		while(true) {
			System.out.println("----[볼]----");
			int length=bshop.size();
			for(int i=0;i<length;i++) {
				System.out.println((i+1)+") ["+bshop.get(i).getBallName()+"]\t "+bshop.get(i).getBallBuyPrice()+"원");
			}
			System.out.println("--------------");
			System.out.println("[1]볼 구매 [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) {
			int idx=-1;
			while(true) {
				System.out.println("볼 번호를 입력하다.");
				idx=_Main.s.nextInt();
				idx--;
				if(idx<0 || idx>bshop.size()) continue;
				else break;
			}
			oneBallInfoShop(idx);
		}
		return;
	}
	
	public void oneBallInfoShop(int idx) {
		int sel=-1;
		System.out.println("["+bshop.get(idx).getBallName()+"] : "+bshop.get(idx).getBallScript());
		while(true) {
			System.out.println("[1]구매하다. [2]뒤로가기");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
			
		if(sel==1) buyBall(idx);
		return;
	}
	
	public void buyBall(int idx) {
		if(HanDAO.getInstance().showMoney()<bshop.get(idx).getBallBuyPrice()) {
			System.out.println("[돈이 부족하다.]");
			String ent=_Main.s.next();
			return;
		}
		
		int checker=-1;
		String bname=bshop.get(idx).getBallName();
		for(int i=0;i<ballList.size();i++) {
			if(ballList.get(i).getBallName().equals(bname)) {
				checker=1;
				ballList.get(i).setBallCnt(ballList.get(i).getBallCnt()+1);
			}
		}
		if(checker!=1) ballList.add(bshop.get(idx));
		HanDAO.getInstance().updateMoney((bshop.get(idx).getBallBuyPrice())*-1);
		System.out.println("[점원] : 구매완료. ▼");
		String ent=_Main.s.next();
	}

}
