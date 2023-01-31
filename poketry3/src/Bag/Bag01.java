package Bag;

import Effect.Effect;

public class Bag01 {
	
	private String useName;
	private int useBuyPrice;
	private int useSellPrice;
	private String useScript;
	private int useCnt;
	private boolean field;
	private boolean battle;
	private Effect effect;
	
	public Bag01(String useName, int useBuyPrice, int useSellPrice, String useScript, int useCnt, boolean field, boolean battle) {
		super();
		this.useName = useName;
		this.useBuyPrice = useBuyPrice;
		this.useSellPrice = useSellPrice;
		this.useScript = useScript;
		this.useCnt = useCnt;
		this.field=field;
		this.battle=battle;
	}
	
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public int getUseBuyPrice() {
		return useBuyPrice;
	}
	public void setUseBuyPrice(int useBuyPrice) {
		this.useBuyPrice = useBuyPrice;
	}
	public int getUseSellPrice() {
		return useSellPrice;
	}
	public void setUseSellPrice(int useSellPrice) {
		this.useSellPrice = useSellPrice;
	}
	public String getUseScript() {
		return useScript;
	}
	public void setUseScript(String useScript) {
		this.useScript = useScript;
	}
	public int getUseCnt() {
		return useCnt;
	}
	public void setUseCnt(int useCnt) {
		this.useCnt = useCnt;
	}
	public boolean isField() {
		return field;
	}
	public void setField(boolean field) {
		this.field = field;
	}
	public boolean isBattle() {
		return battle;
	}
	public void setBattle(boolean battle) {
		this.battle = battle;
	}
	public Effect getEffect() {
		return effect;
	}
	public void setEffect(Effect effect) {
		this.effect = effect;
	}


}
