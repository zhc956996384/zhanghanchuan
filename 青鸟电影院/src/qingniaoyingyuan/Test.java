package qingniaoyingyuan;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Schedule s1 = new Schedule();
		s1.loadltems();
		s1.showInfo();

		System.out.println("下面为影院的座位结构图：");
		System.out.println("\t" + "\t" + "\t" + "屏幕");
		for (int k = 1; k < 6; k++) {
			for (int h = 1; h < 8; h++) {
				System.out.print(k + "-" + h + "\t");
			}
			System.out.println();

		}
		System.out.println("请输入电影的名称：");
		String name = input.next();
		boolean flag=false;
		
			
		
	}

}
