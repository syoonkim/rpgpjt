package Poke;

import Skill.Skill;

public class Poke {

	private String name;
	private int lv;
	private int exp;
	private int maxHp;
	private int curHp;
	private int atk;
	private int def;
	private String type;
	private String status;
	private Skill[] skills;
	private boolean[] onOff;
	private String[] skName;
	
	public Poke(String name, int lv, int exp, int maxHp, int curHp, int atk, int def, String type, String status,
			boolean[] onOff, String[] skName) {
		super();
		this.name = name;
		this.lv = lv;
		this.exp = exp;
		this.maxHp = maxHp;
		this.curHp = curHp;
		this.atk = atk;
		this.def = def;
		this.type = type;
		this.status = status;
		this.onOff = onOff;
		this.skName = skName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Skill[] getSkills() {
		return skills;
	}

	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurHp() {
		return curHp;
	}

	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean[] getOnOff() {
		return onOff;
	}

	public void setOnOff(boolean[] onOff) {
		this.onOff = onOff;
	}

	public String[] getSkName() {
		return skName;
	}

	public void setSkName(String[] skName) {
		this.skName = skName;
	}
	
	
}
