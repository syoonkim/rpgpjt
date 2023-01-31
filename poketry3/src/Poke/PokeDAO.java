package Poke;

import java.util.ArrayList;
import java.util.Collections;

import Bag.BagDAO;
import Han.DexDAO;
import Han.HanDAO;
import Skill.Skill01;
import Skill.Skill02;
import Skill.Skill03;
import Skill.Skill04;
import Skill.Skill05;
import Skill.Skill06;
import Skill.Skill07;
import Skill.Skill08;
import Skill.Skill09;
import Skill.Skill10;
import Skill.Skill11;
import Skill.Skill12;
import Skill.Skill13;
import Skill.Skill14;
import Skill.Skill15;
import Skill.Skill16;
import Skill.Skill17;
import Skill.Skill18;
import _GameManager.Controller;
import _GameManager.EventDAO;
import _GameManager._Main;

public class PokeDAO {
	
	Controller c=new Controller();
	
	private PokeDAO() {}
	static private PokeDAO instance=new PokeDAO();
	static public PokeDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Poke> userpk=new ArrayList<Poke>();
	public ArrayList<Poke> strPk=new ArrayList<Poke>();
	public ArrayList<Poke> r1pk=new ArrayList<Poke>();
//	public ArrayList<Poke> egfstpk=new ArrayList<Poke>();
	public ArrayList<Poke> mob1pk=new ArrayList<Poke>();
	public ArrayList<Poke> mob2pk=new ArrayList<Poke>();
	public ArrayList<Poke> woongpk=new ArrayList<Poke>();
	
	public void initWholePk() {
		initStrPk();
		initR1Pk();
		initGreyPk();
	}
	
	public void addUserPk(Poke p) {
		userpk.add(p);
	}
	
	public void showUserPk() {
		System.out.println("------------------");
		for(int i=0;i<userpk.size();i++) {
			System.out.print((i+1)+") ["+userpk.get(i).getName());
			System.out.print("] lv."+userpk.get(i).getLv());
			System.out.print(" "+userpk.get(i).getType()+"타입\n");
		}
		System.out.println("------------------");
	}
	
	public void showUserPkV2() {
		int length=userpk.size();
		int sel=-1;
		while(true) {
			System.out.println("------------------");
			for(int i=0;i<userpk.size();i++) {
				System.out.print((i+1)+") ["+userpk.get(i).getName());
				System.out.print("] lv."+userpk.get(i).getLv());
				System.out.print(" "+userpk.get(i).getType()+"타입\n");
			}
			System.out.println("------------------");
			System.out.println("[1]순서를 교체하다 [2]놓아주다 [3] 포켓몬 정보 [4]뒤로가기");
			sel=_Main.s.nextInt();
			
			if(sel<0 || sel>3) continue;
			else break;
		}
		if(sel==1) switchPkm();
		else if(sel==2) {
			int rls=-1;
			if(length!=1) {
				while(true) {
					System.out.println("[번호를 입력하다.]");
					rls=_Main.s.nextInt();
					if(rls<0 || rls>length) continue;
					else break;
				}
				rls--;
				System.out.println("["+userpk.get(rls).getName()+"을 놓아주다.] ▼");
				String ent=_Main.s.next();
				System.out.println("[바이바이. "+userpk.get(rls).getName()+"] ▼");
				ent=_Main.s.next();
				userpk.remove(rls);
			}
			else System.out.println("[포켓몬은 최소 한 마리 이상 가지고 있어야한다.]");
		}
		else if(sel==3) {
			int pkidx=-1;
			while(true) {
				System.out.println("[번호를 입력하다.]");
				pkidx=_Main.s.nextInt();
				if(pkidx<0 || pkidx>length) continue;
				else break;
			}
			pkidx--;
			System.out.println("------------------");
			System.out.print("["+userpk.get(pkidx).getName()+"] ");
			if(userpk.get(pkidx).getStatus().equals("잡힘")) System.out.println();
			else System.out.println(userpk.get(pkidx).getStatus());
			System.out.println("LV : "+userpk.get(pkidx).getLv());
			System.out.println("EXP : "+userpk.get(pkidx).getExp()+"/100");
			System.out.println("TYPE : "+userpk.get(pkidx).getType());
			System.out.println("HP : "+userpk.get(pkidx).getCurHp()+"/"+userpk.get(pkidx).getMaxHp());
			System.out.println("ATK : "+userpk.get(pkidx).getAtk());
			System.out.println("DEF : "+userpk.get(pkidx).getDef());
			System.out.println("------------------");
		}
		return;
	}
	
	public int userPkLength() {
		return userpk.size();
	}
	
	public Poke getOneUserPk(int idx) {
		return userpk.get(idx);
	}
	
	public void battleView(Poke sub, Poke obj) {
		System.out.println("["+obj.getName()+"] lv."+obj.getLv()+" Hp"+hpBar(obj.getMaxHp(), obj.getCurHp())+" "+obj.getCurHp()+"/"+obj.getMaxHp());
		System.out.println();
		System.out.println("["+sub.getName()+"] lv."+sub.getLv()+" Hp"+hpBar(sub.getMaxHp(), sub.getCurHp())+" "+sub.getCurHp()+"/"+sub.getMaxHp());
	}
	
	public int battleMenu() {
		int sel=-1;
		while(true) {
			System.out.println("[1]기술 [2]가방 [3]교체 [4]도망치다");
			sel=_Main.s.nextInt();
			if(sel>0 && sel<5) break;
		}
		return sel;
	}
	
	public void battle(Poke sub,Poke obj) {
		int sel=-1;
		String[] sn= {"","","",""};
		for(int i=0;i<sn.length;i++) {
			if(sub.getOnOff()[i]==true) sn[i]=sub.getSkName()[i];
			else sn[i]="- - -";
		}
		while(true) {
			System.out.println("[1]"+sn[0]+" [2]"+sn[1]+"\n[3]"+sn[2]+" [4]"+sn[3]);
			sel=_Main.s.nextInt();
			if(sel>0 && sel<5) break;
		}
		useSkill(sel, sub, obj);
		if(obj.getCurHp()<=0) {
			System.out.println("["+obj.getName()+"은(는) 쓰러졌다.] ▼");
			String ent=_Main.s.next();
			int exp=90;
			System.out.println("["+sub.getName()+"은(는) "+exp+"의 경험치를 획득했다.] ▼");
			ent=_Main.s.next();
			if(sub.getExp()+exp<100) {
				sub.setExp(sub.getExp()+exp);
			}
			else {
				System.out.println("["+sub.getName()+"의 레벨이 올랐다.]");
				sub.setLv(sub.getLv()+1);
				sub.setExp((sub.getExp()+exp)-100);
				evol();
			}
			obj.setStatus("기절");
		}
	}
	
	public void battleOpp(Poke sub,Poke obj) {
		String[] sn= {"","","",""};
		for(int i=0;i<sn.length;i++) {
			if(sub.getOnOff()[i]==true) sn[i]=sub.getSkName()[i];
			else sn[i]="- - -";
		}
		int r=-1;
		while(true) {
			r=_Main.r.nextInt(3);
			if(sn[r].equals("- - -")) continue;
			else break;
		}
		r++;
		useSkill(r, sub, obj);
		if(obj.getCurHp()<=0) {
			System.out.println("["+obj.getName()+"은(는) 쓰러졌다.] ▼");
			String ent=_Main.s.next();
			obj.setStatus("기절");
			System.out.println("[한지우는 눈 앞이 깜깜해졌다.] ▼");
			ent=_Main.s.next();
		}
	}
	
	public void switchPkm() {
		int length=userpk.size();
		while(true) {
			if(length!=1) {
				showUserPk();
				System.out.println("번호를 입력하다.");
				System.out.println("[포켓몬 1] : ");
				int pk1=_Main.s.nextInt();
				if(pk1<0 || pk1>length) continue;
				System.out.println("[포켓몬 2] : ");
				int pk2=_Main.s.nextInt();
				if(pk2<0 || pk2>length) continue;
				
				pk1--;pk2--;
				System.out.println("["+userpk.get(pk1).getName()+"(와)과 "+userpk.get(pk2).getName()+"의 순서를 교체하다.] ▼");
				String ent=_Main.s.next();
				Collections.swap(userpk, pk1, pk2);
				return;
			}
			else {
				System.out.println("[교체할 포켓몬이 없다.] ▼");
				String ent=_Main.s.next();
				return;
			}
		}
	}
	
	public void encR1(int prob) {
		int npc=0;
		System.out.println("[야생의 "+r1pk.get(prob).getName()+"이(가) 나타났다.] ▼");
		String ent=_Main.s.next();
		System.out.println("[가라. "+userpk.get(0).getName()+".] ▼");
		ent=_Main.s.next();
		
		int turn=0;
		while(true) {
			if(turn%2==0) {
				battleView(userpk.get(0), r1pk.get(prob));
				int sel=battleMenu();
				if(sel==1) battle(userpk.get(0),r1pk.get(prob));
				if(sel==2) BagDAO.getInstance().showBagMenuBattle(userpk.get(0),r1pk.get(prob),npc);
				if(sel==3) switchPkm();
				if(sel==4) {
					System.out.println("[야생의 "+r1pk.get(prob).getName()+"로(으로)부터 도망쳤다.] ▼");
					ent=_Main.s.next();
					return;
				}
				turn++;
			}
			else {
				System.out.println();
				battleOpp(r1pk.get(prob),userpk.get(0));
				turn++;
			}
			int cnt=countStunned();
			if(r1pk.get(prob).getStatus().equals("기절") || r1pk.get(prob).getStatus().equals("잡힘") || cnt==userpk.size()) {
				initR1Pk();
				return;
			}
		}
	}
	
	public void battleMob(int ot) {
		ArrayList<Poke> mob=new ArrayList<Poke>();
		int npc=1;
		if(ot==1) {
			mob=mob1pk;
			System.out.println("[웅이부하 원이 승부를 걸어왔다.] ▼");
			String ent=_Main.s.next();
			System.out.println("[웅이부하 원은 "+mob.get(0).getName()+"을(를) 꺼냈다.] ▼");
			ent=_Main.s.next();
		}
		else if(ot==2) {
			mob=mob2pk;
			System.out.println("[웅이부하 투가 승부를 걸어왔다.] ▼");
			String ent=_Main.s.next();
			System.out.println("[웅이부하 투는 "+mob.get(0).getName()+"을(를) 꺼냈다.] ▼");
			ent=_Main.s.next();
		}
		
		System.out.println("[가라. "+userpk.get(0).getName()+".] ▼");
		String ent=_Main.s.next();
		
		int turn=0;
		while(true) {
			if(turn%2==0) {
				battleView(userpk.get(0), mob.get(0));
				int sel=battleMenu();
				if(sel==1) battle(userpk.get(0),mob.get(0));
				if(sel==2) BagDAO.getInstance().showBagMenuBattle(userpk.get(0),mob.get(0),npc);
				if(sel==3) switchPkm();
				if(sel==4) {
					System.out.println("[승부중에 등을 보일 수 없다.] ▼");
					ent=_Main.s.next();
					return;
				}
				turn++;
			}
			else {
				System.out.println();
				battleOpp(mob.get(0),userpk.get(0));
				turn++;
			}
			int cnt=countStunned();
			if(mob.get(0).getStatus().equals("기절")) {
				System.out.println("[승리.] ▼");
				ent=_Main.s.next();
				System.out.println("[한지우는 상금으로 1000원을 획득하다.] ▼");
				ent=_Main.s.next();
				HanDAO.getInstance().updateMoney(1000);
				
				if(ot==1) EventDAO.getInstance().clearEvent04();
				else if(ot==2) EventDAO.getInstance().clearEvent05();
				return;
			}
			if(cnt==userpk.size()) {
				System.out.println("[한지우는 눈앞이 깜깜해졌다.] ▼");
				return;
			}
		}
	}
	public void battleWoong() {
		ArrayList<Poke> mob=new ArrayList<Poke>();
		int npc=1;
		int entry=0;
		int turn=0;
		mob=woongpk;
		System.out.println("[웅이가 승부를 걸어왔다.] ▼");
		String ent=_Main.s.next();
		while(true) {
			System.out.println("[웅은 "+mob.get(entry).getName()+"을(를) 꺼냈다.] ▼");
			ent=_Main.s.next();
			
			if(turn==0) {
				System.out.println("[가라. "+userpk.get(0).getName()+".] ▼");
				ent=_Main.s.next();
			}
			
			while(true) {
				if(turn%2==0) {
					battleView(userpk.get(0), mob.get(entry));
					int sel=battleMenu();
					if(sel==1) battle(userpk.get(0),mob.get(entry));
					if(sel==2) BagDAO.getInstance().showBagMenuBattle(userpk.get(0),mob.get(entry),npc);
					if(sel==3) switchPkm();
					if(sel==4) {
						System.out.println("[승부중에 등을 보일 수 없다.] ▼");
						ent=_Main.s.next();
						return;
					}
					turn++;
				}
				else {
					System.out.println();
					battleOpp(mob.get(entry),userpk.get(0));
					turn++;
				}
				int cnt=countStunned();
				if(mob.get(entry).getStatus().equals("기절")) {
					entry++;
					break;
				}
				if(cnt==userpk.size()) {
					System.out.println("[한지우는 눈앞이 깜깜해졌다.] ▼");
					return;
				}
			}
			if(entry>=mob.size()) {
				System.out.println("[승리.] ▼");
				ent=_Main.s.next();
				System.out.println("[한지우는 상금으로 2000원을 획득하다.] ▼");
				ent=_Main.s.next();
				HanDAO.getInstance().updateMoney(2000);
				System.out.println("[한지우는 회색뱃지를 획득하다.] ▼");
				ent=_Main.s.next();
				HanDAO.getInstance().updateBadges(0);
				EventDAO.getInstance().clearEvent06();
				break;
			}
		}
		return;
	}
	
	public void initStrPk() {
		boolean[] onOff1= {true,true,false,false};
		String[] skName1= {"몸통박치기","울음소리","덩쿨채찍","솔라빔"};
		Poke01 bur=new Poke01("이상해씨",5,0,40,40,25,25,"풀","",onOff1,skName1,new Skill01(),new Skill03(),new Skill06(),new Skill09());
		
		boolean[] onOff2= {true,true,false,false};
		String[] skName2= {"몸통박치기","째려보기","불뿜기","불대문자"};
		Poke04 cha=new Poke04("파이리",5,0,30,30,30,20,"불","",onOff2,skName2,new Skill02(),new Skill04(),new Skill07(),new Skill10());
		
		boolean[] onOff3= {true,true,false,false};
		String[] skName3= {"몸통박치기","웅크리기","물대포","하이드로펌프"};
		Poke07 squ=new Poke07("꼬부기",5,0,50,50,20,30,"물","",onOff3,skName3,new Skill01(),new Skill05(),new Skill08(),new Skill11());
		
		strPk.add(bur);
		strPk.add(cha);
		strPk.add(squ);
	}
	
	public void initR1Pk() {
		r1pk.clear();
		int ran1=_Main.r.nextInt(3)+2;
		boolean[] onOff1= {true,true,false,false};
		String[] skName1= {"몸통박치기","꼬리흔들기","물기","분노의앞니"};
		Poke10 rat=new Poke10("꼬렛",ran1,0,32,32,20,15,"노말","",onOff1,skName1,new Skill01(),new Skill12(),new Skill13(),new Skill14());
		
		int ran2=_Main.r.nextInt(3)+2;
		boolean[] onOff2= {true,true,false,false};
		String[] skName2= {"몸통박치기","울음소리","날개치기","폭풍"};
		Poke12 pid=new Poke12("구구",ran2,0,35,35,10,20,"비행","",onOff2,skName2,new Skill01(),new Skill03(),new Skill15(),new Skill16());
		
		r1pk.add(rat);
		r1pk.add(pid);
	}
	
	public void initGreyPk() {
		boolean[] onOff1= {true,true,false,false};
		String[] skName1= {"몸통박치기","웅크리기","돌떨구기","락블래스트"};
		Poke23 geo1=new Poke23("꼬마돌",9,0,20,20,38,40,"바위","",onOff1,skName1,new Skill01(),new Skill05(),new Skill17(),new Skill18());
		Poke23 geo2=new Poke23("꼬마돌",9,0,20,20,38,40,"바위","",onOff1,skName1,new Skill01(),new Skill05(),new Skill17(),new Skill18());
		Poke23 geo3=new Poke23("꼬마돌",10,0,20,20,40,43,"바위","",onOff1,skName1,new Skill01(),new Skill05(),new Skill17(),new Skill18());
		Poke26 lon=new Poke26("롱스톤",12,0,20,20,42,45,"바위","",onOff1,skName1,new Skill01(),new Skill05(),new Skill17(),new Skill18());
		mob1pk.add(geo1);
		mob2pk.add(geo2);
		woongpk.add(geo3);
		woongpk.add(lon);
	}
	
	public String hpBar(int maxHp, int curHp) {
		String bar="";
		double ratio=curHp/(double)maxHp;
		
		if(ratio>0.8 && ratio<=1) bar="〓〓〓〓〓";
		else if(ratio>0.6 && ratio<=0.8) bar="〓〓〓〓";
		else if(ratio>0.4 && ratio<=0.6) bar="〓〓〓";
		else if(ratio>0.2 && ratio<=0.4) bar="〓〓";
		else if(ratio>0 && ratio<=0.2) bar="〓";
		else if(ratio<=0) bar="";
		return bar;
	}
	
	public void useSkill(int snum, Poke sub, Poke obj) {
		snum--;
		sub.getSkills()[snum].skill(sub, obj);
	}
	
	public int countStunned() {
		int cnt=0;
		for(int i=0;i<userpk.size();i++) {
			if(userpk.get(i).getStatus().equals("기절")) cnt++;
		}
		return cnt;
	}
	
	public void evol() {
		boolean[] evo={true,true,true,false};
		boolean[] evo2={true,true,true,true};
		for(int i=0;i<userpk.size();i++) {
			if(userpk.get(i).getName().equals("이상해씨")) {
				if(userpk.get(i).getLv()==7) {
					userpk.set(i, new Poke02("이상해풀",7,userpk.get(i).getExp(),60,60,34,34,"풀","",evo,userpk.get(i).getSkName(),new Skill01(),new Skill03(),new Skill06(),new Skill09()));
					System.out.println("[어라. 이상해씨의 상태가.] ▼");
					String ent=_Main.s.next();
					System.out.println("[이상해씨는 이상해풀로 진화하였다.] ▼");
					ent=_Main.s.next();
					System.out.println("[이상해풀은 "+userpk.get(i).getSkName()[2]+"을(를) 배웠다.] ▼");
					DexDAO.getInstance().updateDex(2);
				}
			}
			if(userpk.get(i).getName().equals("이상해풀")) {
				if(userpk.get(i).getLv()==10) {
					userpk.set(i, new Poke03("이상해꽃",10,userpk.get(i).getExp(),85,85,50,50,"풀","",evo2,userpk.get(i).getSkName(),new Skill01(),new Skill03(),new Skill06(),new Skill09()));
					System.out.println("[어라. 이상해풀의 상태가.] ▼");
					String ent=_Main.s.next();
					System.out.println("[이상해풀으 이상해꽃으로 진화하였다.] ▼");
					ent=_Main.s.next();
					System.out.println("[이상해꽃은 "+userpk.get(i).getSkName()[3]+"을(를) 배웠다.] ▼");
					DexDAO.getInstance().updateDex(3);
				}
			}
		}
	}
	
	public void healUserPk() {
		for(int i=0;i<userpk.size();i++) {
			userpk.get(i).setCurHp(userpk.get(i).getMaxHp());
			userpk.get(i).setStatus("");
		}
	}
}
