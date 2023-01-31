package _GameManager;

public class Event {
	
//	private Event() {}
//	static private Event instance=new Event();
//	static public Event getInstance() {
//		return instance;
//	}
	
	/*스타팅 포켓몬*/
	private int bu;
	private int ch;
	private int sq;
	
	/*첫 포켓몬 y/n*/
	private boolean event01;
	
	/*도처에 살고 있다.*/
	private boolean event02;
	
	/*포켓몬을 골라봐라.*/
	private boolean event03;
	
	/*npc배틀*/
	private boolean event04;
	private boolean event05;
	private boolean event06;
	
	public int getBu() {
		return bu;
	}
	public void setBu(int bu) {
		this.bu = bu;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public int getSq() {
		return sq;
	}
	public void setSq(int sq) {
		this.sq = sq;
	}
	
	public boolean isEvent01() {
		return event01;
	}
	public void setEvent01(boolean event01) {
		this.event01 = event01;
	}
	public boolean isEvent02() {
		return event02;
	}
	public void setEvent02(boolean event02) {
		this.event02 = event02;
	}
	public boolean isEvent03() {
		return event03;
	}
	public void setEvent03(boolean event03) {
		this.event03 = event03;
	}
	public boolean isEvent04() {
		return event04;
	}
	public void setEvent04(boolean event04) {
		this.event04 = event04;
	}
	public boolean isEvent05() {
		return event05;
	}
	public void setEvent05(boolean event05) {
		this.event05 = event05;
	}
	public boolean isEvent06() {
		return event06;
	}
	public void setEvent06(boolean event06) {
		this.event06 = event06;
	}
	
	

}
