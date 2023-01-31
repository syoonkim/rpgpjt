package Area;

public class AreaData {
	private AreaData() {}
	static private AreaData instance=new AreaData();
	static public AreaData getInstance() {
		return instance;
	}
	
	static int[] dx={-1,0,1,0};
	static int[] dy={0,1,0,-1};
	
	public void printArea(int[][]map, int[] loc) {
		int size=map.length;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i==loc[0] && j==loc[1]) System.out.print(" 옷 ");
				/*고정 - 상호작용 가능*/
				else if(map[i][j]==-1) System.out.print(" 옷 "); // mom
				else if(map[i][j]==-2) System.out.print(" 옷 "); // dr.Oh
				else if(map[i][j]==-3) System.out.print(" 옷 "); // wind
				else if(map[i][j]==-4) System.out.print(" 옷 "); // capboy
				else if(map[i][j]==-5) System.out.print(" 옷 "); // insectboy
				else if(map[i][j]==-6) System.out.print(" 옷 "); // girl
				else if(map[i][j]==-7) System.out.print("[■]"); // healer
				else if(map[i][j]==-8) System.out.print("[■]"); // clerk
				else if(map[i][j]==-9) System.out.print(" 옷 "); // ggo1
				else if(map[i][j]==-10) System.out.print(" 옷 ");	// ggo2
				else if(map[i][j]==-11) System.out.print(" 옷 ");	// woong
				else if(map[i][j]==-12) System.out.print(" 홋 ");	// rkd1
				else if(map[i][j]==-13) System.out.print(" 홋 ");	// rkd2
				else if(map[i][j]==-14) System.out.print(" o "); // ballBurb
				else if(map[i][j]==-15) System.out.print(" o "); // ballChar
				else if(map[i][j]==-16) System.out.print(" o "); // ballSqui
				
				/*고정 - 상호작용 불가능*/
				else if(map[i][j]==-17) System.out.print("[■]"); // basicWall
				else if(map[i][j]==-18) System.out.print("[▒]"); // water
				else if(map[i][j]==-19) System.out.print("[-]"); // hrzFence
				else if(map[i][j]==-20) System.out.print("[|]"); // vtcFence
				else if(map[i][j]==-21) System.out.print("[♠]"); // tree
				
				else if(map[i][j]==-31) System.out.print(" H "); // home
				else if(map[i][j]==-33) System.out.print(" L "); // laboratory
				else if(map[i][j]==-37) System.out.print(" C "); // pkmCenter
				else if(map[i][j]==-38) System.out.print(" S "); // friendlyShop
				else if(map[i][j]==-39) System.out.print(" G "); // gym
				else if(map[i][j]==-40) System.out.print(" M "); // museum
				else if(map[i][j]==-41) System.out.print("[★]"); // goods
				
				/*비고정*/
				else if(map[i][j]==0) System.out.print("   "); // justFloor
				else if(map[i][j]==1) System.out.print("   "); // toHome
				else if(map[i][j]==2) System.out.print("   "); // toTownOrg
				else if(map[i][j]==3) System.out.print("   "); // toLabratory
				else if(map[i][j]==4) System.out.print("   "); // toRoute1
				else if(map[i][j]==5) System.out.print("   "); // toEvgFst
				else if(map[i][j]==6) System.out.print("   "); // toTownGrey
				else if(map[i][j]==7) System.out.print("   "); // toPkmCenter
				else if(map[i][j]==8) System.out.print("   "); // toFriendlyShop
				else if(map[i][j]==9) System.out.print("   "); // toGym
				else if(map[i][j]==10) System.out.print(" # "); // bushes
				else if(map[i][j]==11) System.out.print("   "); // toRoute2
				else if(map[i][j]==12) System.out.print("   "); // toMuseum
				else if(map[i][j]==13) System.out.print("   ");
				else if(map[i][j]==14) System.out.print("   ");
			}
			System.out.println();
		}
	}
	
	public int[][] settingFence(int[][] map) {
		int s1=map.length;
		int s2=map[0].length;
		for(int i=0;i<s1;i++) {
			for(int j=0;j<s2;j++) {
				if(i==0 || i==s1-1 || j==0 || j==s2-1) map[i][j]=-17;
			}
		}
		return map;
	}
	
	
	public int nextCellIsNpc(int[][] map, int[] loc) {
		for(int i=0;i<dx.length;i++) {
			int y=loc[0]+dy[i];
			int x=loc[1]+dx[i];
			if(map[y][x]<0 && map[y][x]>-17) {
				System.out.println("\n[1]↑ [2]↓ [3]← [4]→ [5]대화하다. [0]메뉴");
				return map[y][x];
			}
		}
		System.out.println("\n[1]↑ [2]↓ [3]← [4]→ [0]메뉴");
		return 0;
	}
	
	public int[] move(int[][] map, int[] loc, int sel) {
		int ny=loc[0];
		int nx=loc[1];
		
		if(sel==1) {
			ny--;
			if(map[ny][nx]>=0) loc[0]--;
		}
		if(sel==2) {
			ny++;
			if(map[ny][nx]>=0) loc[0]++;
		}
		if(sel==3) {
			nx--;
			if(map[ny][nx]>=0) loc[1]--;
		}
		if(sel==4) {
			nx++;
			if(map[ny][nx]>=0) loc[1]++;
		}
		return loc;
	}

}
