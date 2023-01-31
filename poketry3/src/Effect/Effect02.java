package Effect;

import Poke.Poke;
import Poke.PokeDAO;
import _GameManager._Main;

public class Effect02 implements Effect {
	/*이상한사탕*/

	@Override
	public void effect(Poke sub) {
		System.out.println("["+sub.getName()+"의 레벨이 1 상승하다.] ▼");
		String ent=_Main.s.next();
		sub.setLv(sub.getLv()+1);
		PokeDAO.getInstance().evol();
	}

}
