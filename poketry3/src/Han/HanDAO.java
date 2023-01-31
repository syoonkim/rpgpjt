package Han;

import java.util.ArrayList;

public class HanDAO {
	
	private HanDAO() {}
	static private HanDAO instance=new HanDAO();
	static public HanDAO getInstance() {
		return instance;
	}
	
	Han h;
	
	public void initHan() {
		boolean[] b={false,false,false,false,false,false,false,false};
		String[] n={"회색배지","그린배지","블루배지","골드배지","핑크배지","무지개배지","오렌지배지","진홍색배지"};
		h=new Han();
		h.setBadges(b);
		h.setBg(n);
		h.setPkcnt(0);
		h.setMoney(3000);
	}
	
	public void hanInfo() {
		int cnt=0;
		ArrayList<Dex> dx=DexDAO.getInstance().dxList;
		for(int i=0;i<dx.size();i++) {
			if(dx.get(i).isHave()==true) cnt++;
		}
		System.out.print("=====[한지우]=====\n[이름 : 한지우]\n[보유 용돈 : "+h.getMoney()+"원]\n[찾은 포켓몬 수 : "+cnt+"마리]\n[보유 배지 :");
		for(int i=0;i<h.getBadges().length;i++) {
			if(h.getBadges()[i]==true) System.out.print("["+h.getBg()[i]+"]");
		}
		System.out.println(" ]\n================");
	}
	
	public void updateBadges(int bgNum) {
		boolean[] b=new boolean[8];
		for(int i=0;i<b.length;i++) {
			if(i==bgNum) b[i]=true;
			else b[i]=false;
		}
		h.setBadges(b);
	}
	
	public int showMoney() {
		return h.getMoney();
	}
	
	public void updateMoney(int prc) {
		h.setMoney(h.getMoney()+prc);
	}

}
