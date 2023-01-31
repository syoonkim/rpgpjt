package Bag;

public class Bag02 {
	
	private int ballNum;
	private String ballName;
	private int ballBuyPrice;
	private int ballSellPrice;
	private String ballScript;
	private int ballCnt;
	private int ballRate;
	private boolean field;
	private boolean battle;
	
	public Bag02(int ballNum, String ballName, int ballBuyPrice, int ballSellPrice, String ballScript, int ballCnt,
			int ballRate, boolean field, boolean battle) {
		super();
		this.ballNum = ballNum;
		this.ballName = ballName;
		this.ballBuyPrice = ballBuyPrice;
		this.ballSellPrice = ballSellPrice;
		this.ballScript = ballScript;
		this.ballCnt = ballCnt;
		this.ballRate = ballRate;
		this.field=field;
		this.battle=battle;
	}
	public int getBallNum() {
		return ballNum;
	}
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}
	public String getBallName() {
		return ballName;
	}
	public void setBallName(String ballName) {
		this.ballName = ballName;
	}
	public int getBallBuyPrice() {
		return ballBuyPrice;
	}
	public void setBallBuyPrice(int ballBuyPrice) {
		this.ballBuyPrice = ballBuyPrice;
	}
	public int getBallSellPrice() {
		return ballSellPrice;
	}
	public void setBallSellPrice(int ballSellPrice) {
		this.ballSellPrice = ballSellPrice;
	}
	public String getBallScript() {
		return ballScript;
	}
	public void setBallScript(String ballScript) {
		this.ballScript = ballScript;
	}
	public int getBallCnt() {
		return ballCnt;
	}
	public void setBallCnt(int ballCnt) {
		this.ballCnt = ballCnt;
	}
	public int getBallRate() {
		return ballRate;
	}
	public void setBallRate(int ballRate) {
		this.ballRate = ballRate;
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
	

}
