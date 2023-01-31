package Effect;

import Poke.Poke;
import _GameManager._Main;

public class Effect03 implements Effect {
	/*좋은상처약*/

	@Override
	public void effect(Poke sub) {
		int heal=50;
		if(sub.getCurHp()+heal>sub.getMaxHp()) {
			System.out.println("["+sub.getName()+"의 HP가 "+((heal+sub.getCurHp())-sub.getMaxHp())+"회복되다.] ▼");
			String ent=_Main.s.next();
			sub.setCurHp(sub.getMaxHp());
		}
		else {
			System.out.println("["+sub.getName()+"의 HP가 "+heal+"회복되다.] ▼");
			String ent=_Main.s.next();
			sub.setCurHp(sub.getCurHp()+heal);
		}
	}

}
