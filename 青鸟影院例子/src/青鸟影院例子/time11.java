package 青鸟影院例子;

import java.util.Random;

public class time11 {
	static String chars = "abcdefghijklmnopqr";
	public static void main(String[] args) {
	int suiji = new Random().nextInt(20);
	System.out.print(suiji);
	System.out.print(chars.charAt((int)(Math.random() * 18))+"\t");
	}
}
