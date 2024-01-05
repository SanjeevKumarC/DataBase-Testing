package LearningJavaProgram;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public interface JavaEx {
	public static void main(String[] args) {
		/*
		 * //Can we get length and reverse the null , No because it throw
		 * nullPointerException String s = null; StringBuilder sb = new
		 * StringBuilder(s); sb.reverse();
		 */

		/*
		 * Swapping numbers without using a third variable int a=6,b=23; b=a+b; a=b-a;
		 * b=b-a; System.out.println(a +" "+b);
		 */

		/*
		 * // check whether the string contains vowels String v = "bcay"; String vow =
		 * "aeiou"; Boolean b = false; for (int i = 0; i < v.length(); i++) { for (int j
		 * = 0; j < vow.length(); j++) { if (v.charAt(i) == vow.charAt(j)) b = true; } }
		 * // Another way to check
		 * System.out.println(v.toLowerCase().matches(".*[aeiou].*"));// (".*[aeiou].*)
		 */

		/*
		 * // remove spaces from a string in Java String s =
		 * " san j   eev     @ g mail  . co m "; // s=s.replace(" ","");
		 * System.out.println(s); // Another way to remove space char[] ch =
		 * s.toCharArray(); for (int i = 0; i < ch.length; i++) { if
		 * (Character.isWhitespace(ch[i]) == false) System.out.print(ch[i]); }
		 */

		/*
		 * // Suffle array using random class int a[] = { 1, 2, 3, 4, 5 }; Random r =
		 * new Random(); for (int i = 0; i < a.length; i++) { int Randomind =
		 * r.nextInt(a.length); int temp = a[Randomind]; a[Randomind] = a[i]; a[i] =
		 * temp; } System.out.println(Arrays.toString(a));// to print all the values
		 * without using loop
		 */
		
		/*
		 * //Print date in specific format
		 * SimpleDateFormat f=new SimpleDateFormat("dd-MMM-yyyy");
		 * System.out.println(f.format(new Date()));
		 */
		List<Integer> li=new ArrayList<>(Arrays.asList(1,2,3,4,5));
		li.forEach(System.out::println);
		
	}
}
