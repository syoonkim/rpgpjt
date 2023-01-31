package Area;

import Bag.BagDAO;
import Poke.PokeDAO;
import _GameManager._Main;

public class Script {
	
	private Script() {}
	static private Script instance=new Script();
	static public Script getInstance() {
		return instance;
	}
	
	
	
	/*a01*/
	public void scpt1() {
		System.out.println("[엄마] : 조심히 다녀오렴 지우야.");
	}
	
	/*a03*/
	public void scpt2() {
		System.out.print("[오박사] : 세계 도처에는 다양한 포켓몬이 살고 있다. ▼");
		String ent=_Main.s.next();
		System.out.print("[오박사] : 도감을 주겠다. ▼");
		ent=_Main.s.next();
		System.out.print("[도감을 얻었다.] ▼");
		ent=_Main.s.next();
	}
	
	public int scpt3() {
		System.out.print("[오박사] : 물타입 포켓몬 꼬부기다. ▼");
		String ent=_Main.s.next();
		System.out.print("[오박사] : 내구력이 준수하지만 화력이 아쉽다. ▼");
		ent=_Main.s.next();
		int sel=choice();
		System.out.println(sel);
		return sel;
	}
	
	public int scpt4() {
		System.out.print("[오박사] : 불타입 포켓몬 파이리다. ▼");
		String ent=_Main.s.next();
		System.out.print("[오박사] : 공격력이 높지만 체력이 낮다. ▼");
		ent=_Main.s.next();
		int sel=choice();
		System.out.println(sel);
		return sel;
	}
	
	public int scpt5() {
		System.out.print("[오박사] : 풀타입 포켓몬 이상헤씨다. ▼");
		String ent=_Main.s.next();
		System.out.print("[오박사] : 초보자가 키우기 쉬운 밸런스형 몬스터다. ▼");
		ent=_Main.s.next();
		int sel=choice();
		System.out.println(sel);
		return sel;
	}
	
	public void scpt6() {
		System.out.print("[오박사] : 이제 포켓몬을 선택해라. ▼");
		String ent=_Main.s.next();
	}
	
	public void scpt7() {
		System.out.print("[오박사] : 이제 세계를 여행하며 포켓몬을 모으고 ▼");
		String ent=_Main.s.next();
		System.out.print("[오박사] : 체육관 배지를 모아서 챔피언에 도전해봐라.");
		ent=_Main.s.next();
	}
	
	public void scpt8() {
		int sel=-1;
		while(true) {
			System.out.println("[간호순] : 포켓몬을 치료하겠습니까. ▼");
			System.out.println("[1]y [2]n");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>2) continue;
			else break;
		}
		if(sel==1) {
			PokeDAO.getInstance().healUserPk();
			System.out.println("[간호순] : 치료가 완료되었습니다. ▼");
			String ent=_Main.s.next();
		}
		System.out.println("[간호순] : 들어가세요. ▼");
		String ent=_Main.s.next();
	}
	
	public void scpt9() {
		int sel=-1;
		System.out.println("[점원] : 어서오세요. ▼");
		while(true) {
			System.out.println("[1]소비템 [2]볼 [3]다음에");
			sel=_Main.s.nextInt();
			if(sel<0 || sel>3) continue;
			
			if(sel==1) BagDAO.getInstance().showIshop();
			else if(sel==2) BagDAO.getInstance().showBshop();
			else break;
		}
		return;
	}
	
	public void scpt10() {
		System.out.println("[웅이 부하] : 바위포켓몬은 최강이다. ▼");
		String ent=_Main.s.next();
	}
	
	public void scpt11() {
		System.out.println("[웅이 부하] : 난 강하다. ▼");
		String ent=_Main.s.next();
	}
	
	public void scpt12() {
		System.out.println("[웅이] : 시작하지. ▼");
		String ent=_Main.s.next();
		PokeDAO.getInstance().battleWoong();
	}
	
	public void scpt13() {
		System.out.println("[웅이] : ... ▼");
		String ent=_Main.s.next();
	}
	
	public void scpt14() {
		System.out.println("[로켓단] : 꺼져라. ▼");
		String ent=_Main.s.next();
	}
	
	public int choice() {
		int sel=0;
		while(true) {
			System.out.print("[1] 선택하다. [2] 보류하다.");
			sel=_Main.s.nextInt();
			if(sel>2 || sel<1) continue;
			else break;
		}
		return sel;
	}
	
}
