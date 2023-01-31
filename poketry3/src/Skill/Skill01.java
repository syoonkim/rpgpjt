package Skill;

import Poke.Poke;
import _GameManager._Main;

public class Skill01 implements Skill {
	/*몸통박치기*/
	
	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 몸통박치기 공격.]");
		int crit=_Main.r.nextInt(9);
		int pw=6;
		if(crit==0) {
			System.out.println("[급소에 맞았다.]");
			pw=pw*2;
		}
		
		if(obj.getType().equals("고스트")) {
			System.out.println("["+obj.getName()+"에게는 효과가 없는듯 하다.]");
			pw=0;
		}
		System.out.println("["+obj.getName()+"에게 "+pw+"의 데미지를 입히다.]");
		obj.setCurHp(obj.getCurHp()-pw);
	}

}
