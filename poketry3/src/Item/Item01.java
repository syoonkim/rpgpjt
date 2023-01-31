package Item;

import Bag.Bag01;
import Effect.Effect01;
import Poke.Poke;

public class Item01 extends Bag01{
	
	Effect01 effect;

	public Item01(String useName, int useBuyPrice, int useSellPrice, String useScript, int useCnt,
			boolean field, boolean battle, Effect01 effect) {
		super(useName, useBuyPrice, useSellPrice, useScript, useCnt, field, battle);
		this.effect=effect;
		super.setEffect(effect);
	}
	
	public void effect(Poke sub) {
		effect.effect(sub);
	}

}
