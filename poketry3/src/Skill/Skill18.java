package Skill;

import Poke.Poke;
import _GameManager._Main;

public class Skill18 implements Skill{
	/*락블래스트*/

	@Override
	public void skill(Poke sub, Poke obj) {
		System.out.println("["+sub.getName()+"의 락블래스트.]");
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"발");
			int crit=_Main.r.nextInt(9);
			int pw=4;
			if(crit==0) {
				System.out.println("[급소에 맞았다.]");
				pw=pw*2;
			}
			else if(crit==1) {
				System.out.println("["+sub.getName()+"의 공격이 빗나갔다.]");
				pw=0;
				continue;
			}
			
			boolean x2=false;
			boolean x12=false;
			if(obj.getType().equals("격투") || obj.getType().equals("땅") || 
			   obj.getType().equals("강철")) x12=true;
					
			if(obj.getType().equals("불") || obj.getType().equals("얼음") || 
			   obj.getType().equals("벌레") || obj.getType().equals("비행")) x2=true;
			
			
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
			String ent=_Main.s.next();
		}
		
	}

}
