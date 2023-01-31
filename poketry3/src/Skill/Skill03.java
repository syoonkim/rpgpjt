package Skill;

import Poke.Poke;

public class Skill03 implements Skill {
	/*울음소리*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 울음소리.]");
		System.out.println("["+obj.getName()+"의 공격력이 감소했다.]");
		obj.setAtk(obj.getAtk()/4); 
	}

}
