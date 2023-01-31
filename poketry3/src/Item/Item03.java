package Item;

import Bag.Bag01;
import Effect.Effect03;
import Poke.Poke;

public class Item03 extends Bag01{
	
	Effect03 effect;

	public Item03(String useName, int useBuyPrice, int useSellPrice, String useScript, int useCnt,
			boolean field, boolean battle, Effect03 effect) {
		super(useName, useBuyPrice, useSellPrice, useScript, useCnt, field, battle);
		this.effect=effect;
		super.setEffect(effect);
	}
	
	public void effect(Poke sub) {
		effect.effect(sub);
	}

}
