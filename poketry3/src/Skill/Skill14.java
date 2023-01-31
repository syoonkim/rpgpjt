package Skill;

import Poke.Poke;

public class Skill14 implements Skill {
	/*분노의 앞니*/
	
	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 분노의 앞니.]");
		
		if(obj.getType().equals("고스트")) {
			System.out.println("["+obj.getName()+"에게는 효과가 없는듯 하다.]");
		}
		else {
			System.out.println("["+obj.getName()+"에게 "+obj.getCurHp()/2+"의 데미지를 입히다.]");
			obj.setCurHp(obj.getCurHp()/2);
		}
	}

}
