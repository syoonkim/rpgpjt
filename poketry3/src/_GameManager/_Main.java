package _GameManager;

import java.util.Random;
import java.util.Scanner;

public class _Main {
	static public Scanner s;
	static public Random r;
	public static void main(String[] args) {
		s=new Scanner(System.in);
		r=new Random();
		Controller ct=new Controller();
		
		ct.run();
		
	}

}
