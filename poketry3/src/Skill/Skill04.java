package Skill;

import Poke.Poke;

public class Skill04 implements Skill {
	/*째려보기*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 째려보기.]");
		System.out.println("["+obj.getName()+"의 방어력이 감소했다.]");
		obj.setDef(obj.getDef()/4); 
	}

}
