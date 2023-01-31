package Skill;

import Poke.Poke;

public class Skill12 implements Skill {
	/*꼬리흔들기*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 꼬리흔들기.]");
		System.out.println("["+obj.getName()+"의 방어력이 감소했다.]");
		obj.setDef(obj.getDef()/4); 
	}

}
