package LearningJavaProgram;

import java.util.Arrays;

public class SecondLargetNumber {

	public static void main(String[] args) {
		int a[] = { 2, 5, 3, 4, 6 };
		Arrays.sort(a);
		System.out.println(a[a.length - 2]);
		//Another way using for loop
		int h = a[0];
		int sec = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > h) {
				sec = h;
				h = a[i];
			} else if (h < sec) {
				sec = a[i];
			}
		}
		System.out.println(sec);
		
	}

}
