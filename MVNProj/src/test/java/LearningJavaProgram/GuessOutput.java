package LearningJavaProgram;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GuessOutput {

	public static final void main(String[] args) {
		/*
		 * String s1 = "abc"; String s2 = "abc"; System.out.println("s1 == s2 is:"+s1 ==
		 * s2 );//false (“s1 == s2 is:abc” == “abc”) System.out.println(s1 == s2);//true
		 */

		/*
		 * String x = "abc"; String y = "abc"; x.concat(y); System.out.println(x);
		 * x=x.concat(y); System.out.println(x);
		 */

		/*
		 * char ch = 'a'; String r = "abca";
		 * //System.out.println(r.replace(Character.toString(ch), "")); String s=new
		 * String("abca"); System.out.println(r==s); s=s.intern();//intern() method
		 * returns the String object reference from the string pool
		 * System.out.println(r==s);
		 */

		String str="ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+("FIVE"+5+9);  
		System.out.println(str+1+4); 
		
	}

}
