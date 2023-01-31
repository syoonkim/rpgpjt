package _GameManager;

import java.util.HashMap;
import java.util.Map;

import Area.Area;
import Area.Area01;
import Area.Area02;
import Area.Area03;
import Area.Area04;
import Area.Area05;
import Area.Area06;
import Area.Area07;
import Area.Area08;
import Area.Area09;
import Bag.BagDAO;
import Han.DexDAO;
import Han.HanDAO;
import Poke.PokeDAO;

public class Controller {
	
	EventDAO eventDAO;
	DexDAO dexDAO;
	PokeDAO pokeDAO;
	BagDAO bagDAO;
	HanDAO hanDAO;
	
	Map<Integer, Area> areaList=new HashMap<Integer, Area>();
	int curAreaNum=-1;
	int nextAreaNum=-1;
	
	int[] loc={3,2};
	
	void init() {
		eventDAO=EventDAO.getInstance();
		eventDAO.initEvents();
		dexDAO=DexDAO.getInstance();
		dexDAO.initDex();
		pokeDAO=PokeDAO.getInstance();
		pokeDAO.initWholePk();
		bagDAO=BagDAO.getInstance();
		bagDAO.initBag();
		hanDAO=HanDAO.getInstance();
		hanDAO.initHan();
		areaList.put(1, new Area01());
		areaList.put(2, new Area02());
		areaList.put(3, new Area03());
		areaList.put(4, new Area04());
		areaList.put(5, new Area05());
		areaList.put(6, new Area06());
		areaList.put(7, new Area07());
		areaList.put(8, new Area08());
		areaList.put(9, new Area09());
		nextAreaNum=1;
	}
	
	void run() {
		init();
		play();
	}
	
	void play() {
		while(true) {
			nextAreaNum=changeArea(nextAreaNum);
			if(nextAreaNum==12) break;
		}
		System.out.println("[게임 종료]");
	}
	
	int changeArea(int nextAreaNum) {
		curAreaNum=nextAreaNum;
		Area currentArea=areaList.get(curAreaNum);
		currentArea.init(loc);
		
		int area=curAreaNum;
		while(true) {
			area=currentArea.update(loc);
			if(area!=curAreaNum) break;
		}		
		return area;
	}

}
