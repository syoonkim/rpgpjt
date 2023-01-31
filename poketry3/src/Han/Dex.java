package Han;

class Dex {
	
	private int num;
	private String name;
	private String type;
	private String script;
	private boolean have;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public boolean isHave() {
		return have;
	}

	public void setHave(boolean have) {
		this.have = have;
	}

	public Dex(int num, String name, String type, String script, boolean have) {
		this.num = num;
		this.name = name;
		this.type = type;
		this.script = script;
		this.have = have;
	}
	
}