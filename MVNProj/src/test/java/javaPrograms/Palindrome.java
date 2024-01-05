package javaPrograms;

import java.util.Iterator;

public class Palindrome {

	public static void main(String[] args) {
//		int p =12321;
//		int dup=p;
//		int r=0;
//		while (p!=0) {
//			r=r*10+p%10;
//			p=p/10;
//		}
//		System.out.println(r==dup);

		String s="12321";
		String d="";
		 for (int i = s.length()-1;i>=0; i--) {
			d=d+s.charAt(i);
			
		}
		 System.out.println(d.equalsIgnoreCase(s));
		
	}

}
