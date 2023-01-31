package Skill;

import Poke.Poke;

public class Skill05 implements Skill {
	/*웅크리기*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 웅크리기.]");
		System.out.println("["+sub.getName()+"의 방어력이 증가했다.]");
		sub.setDef((sub.getDef()*5)/4); 
	}

}
