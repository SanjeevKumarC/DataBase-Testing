package LearningJavaProgram;

import java.util.HashMap;
import java.util.Iterator;

public class OccuranceOfCharInString {

	public static void main(String[] args) {
		// distinct characters and their count in a string in Java?

		String s = "aaaabbbccd";
		s=s.replace(" ","");
		char[] c = s.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (Character d : c) {
			if(hm.containsKey(d)) 
				hm.put(d, hm.get(d)+1);// Logic?
			else
				hm.put(d, 1);
		}
		System.out.println(hm);
	}

}
