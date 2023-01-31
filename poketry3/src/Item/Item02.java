package Item;

import Bag.Bag01;
import Effect.Effect02;
import Poke.Poke;

public class Item02 extends Bag01 {
	
	Effect02 effect;

	public Item02(String useName, int useBuyPrice, int useSellPrice, String useScript, int useCnt, boolean field,
			boolean battle, Effect02 effect) {
		super(useName, useBuyPrice, useSellPrice, useScript, useCnt, field, battle);
		this.effect=effect;
		super.setEffect(effect);
	}
	
	public void effect(Poke sub) {
		effect.effect(sub);
	}

}
