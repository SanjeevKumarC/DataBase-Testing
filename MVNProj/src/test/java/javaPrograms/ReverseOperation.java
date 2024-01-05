package javaPrograms;

import dev.failsafe.internal.util.Assert;

public class ReverseOperation {

	public static void main(String[] args) throws Exception {
		String s="sanjeev kumar";
		String[] w = s.split(" ");
		String r="";
		String w2=w[1].toString();
		for (int i =w2.length()-1; i >=0; i--) {
		r=r+w2.charAt(i);
		}
		r=w[0].toString()+" "+r;
		System.out.println(r);
		
		String c="abC";
		System.out.println(c.indexOf('c'));
		
//		Assert.isTrue(c.indexOf('d')==-2,"hello");
//		System.out.println("true");
	}

}
