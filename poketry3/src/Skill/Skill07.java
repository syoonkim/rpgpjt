package Skill;

import Poke.Poke;
import _GameManager._Main;

public class Skill07 implements Skill {
	/*불뿜기*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 불뿜기 공격.]");
		int crit=_Main.r.nextInt(9);
		int pw=8;
		if(crit==0) {
			System.out.println("[급소에 맞았다.]");
			pw=pw*2;
		}
		
		boolean x2=false;
		boolean x12=false;
		if(obj.getType().equals("불") || obj.getType().equals("물") || 
		   obj.getType().equals("바위") || obj.getType().equals("드래곤")) x12=true;
		
		if(obj.getType().equals("풀") || obj.getType().equals("벌레") || 
		   obj.getType().equals("얼음") || obj.getType().equals("강철")) x2=true;
		
		
		if(x12) {
			System.out.println("[효과가 부족한듯 하다.]");
			pw=pw/2;
		}
		if(x2) {
			System.out.println("[효과가 굉장했다.]");
			pw=pw*2;
		}
		System.out.println("["+obj.getName()+"에게 "+pw+"의 데미지를 입히다.]");
		obj.setCurHp(obj.getCurHp()-pw);
	}

}
