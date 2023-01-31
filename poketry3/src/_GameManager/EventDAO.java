package _GameManager;

public class EventDAO {
	
	Event e=new Event();
	
	private EventDAO() {}
	static private EventDAO instance=new EventDAO();
	static public EventDAO getInstance() {
		return instance;
	}
	
	public void initEvents() {
		e.setBu(-14);
		e.setCh(-15);
		e.setSq(-16);
		e.setEvent01(false);
		e.setEvent02(false);
		e.setEvent04(false);
		e.setEvent05(false);
		e.setEvent06(false);
	}
	
	public int getterB() {
		return e.getBu();
	}
	public int getterC() {
		return e.getCh();
	}
	public int getterS() {
		return e.getSq();
	}
	
	public void takeBur() {
		e.setBu(0);
	}
	public void takeCha() {
		e.setCh(0);
	}
	public void takeSqu() {
		e.setSq(0);
	}
	
	public boolean checkEvent01() {
		boolean c=e.isEvent01();
		return c;
	}
	
	public void clearEvent01() {
		e.setEvent01(true);
	}
	
	public boolean checkEvent02() {
		boolean c=e.isEvent02();
		return c;
	}
	
	public void clearEvent02() {
		e.setEvent02(true);
	}
	
	public boolean checkEvent03() {
		boolean c=e.isEvent03();
		return c;
	}
	
	public void clearEvent03() {
		e.setEvent03(true);
	}
	
	public boolean checkEvent04() {
		boolean c=e.isEvent04();
		return c;
	}
	
	public void clearEvent04() {
		e.setEvent04(true);
	}
	
	public boolean checkEvent05() {
		boolean c=e.isEvent05();
		return c;
	}
	
	public void clearEvent05() {
		e.setEvent05(true);
	}
	
	public boolean checkEvent06() {
		boolean c=e.isEvent06();
		return c;
	}
	
	public void clearEvent06() {
		e.setEvent06(true);
	}

}
