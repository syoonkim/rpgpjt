package Poke;

import Skill.Skill;
import Skill.Skill01;
import Skill.Skill03;
import Skill.Skill15;
import Skill.Skill16;

public class Poke12 extends Poke {
	/*구구*/
	Skill01 sk1;
	Skill03 sk2;
	Skill15 sk3;
	Skill16 sk4;

	public Poke12(String name, int lv, int exp, int maxHp, int curHp, int atk, int def, 
				  String type, String status, boolean[] onOff, String[] skName,
				  Skill01 sk1, Skill03 sk2, Skill15 sk3, Skill16 sk4) {
		super(name, lv, exp, maxHp, curHp, atk, def, type, status, onOff, skName);
		this.sk1=sk1;
		this.sk2=sk2;
		this.sk3=sk3;
		this.sk4=sk4;
		Skill temp[] = {sk1,sk2,sk3,sk4};
		super.setSkills(temp);
	}
	
	void sk1(Poke sub, Poke obj) {
		sk1.skill(sub, obj);
	}
	
	void sk2(Poke sub, Poke obj) {
		sk2.skill(sub, obj);
	}
	
	void sk3(Poke sub, Poke obj) {
		sk3.skill(sub, obj);
	}
	
	void sk4(Poke sub, Poke obj) {
		sk4.skill(sub, obj);
	}
}
