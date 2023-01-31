package Poke;

import Skill.Skill;
import Skill.Skill01;
import Skill.Skill03;
import Skill.Skill06;
import Skill.Skill09;

public class Poke01 extends Poke {
	/*이상해씨*/
	Skill01 sk1;
	Skill03 sk2;
	Skill06 sk3;
	Skill09 sk4;

	public Poke01(String name, int lv, int exp, int maxHp, int curHp, int atk, int def, 
				  String type, String status, boolean[] onOff, String[] skName,
				  Skill01 sk1, Skill03 sk2, Skill06 sk3, Skill09 sk4) {
		super(name, lv, exp, maxHp, curHp, atk, def, type, status, onOff, skName);
		this.sk1=sk1;
		this.sk2=sk2;
		this.sk3=sk3;
		this.sk4=sk4;
		Skill temp[] = {sk1,sk2,sk3,sk4};
		super.setSkills(temp);
	}
	
	public void sk1(Poke sub, Poke obj) {
		sk1.skill(sub, obj);
	}
	
	public void sk2(Poke sub, Poke obj) {
		sk2.skill(sub, obj);
	}
	
	public void sk3(Poke sub, Poke obj) {
		sk3.skill(sub, obj);
	}
	
	public void sk4(Poke sub, Poke obj) {
		sk4.skill(sub, obj);
	}
}
