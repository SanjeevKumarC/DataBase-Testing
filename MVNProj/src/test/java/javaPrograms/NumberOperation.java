package javaPrograms;

public class NumberOperation {

	public static void main(String[] args) {
		// Biggest Among three number
		/*
		 * int a = 9, b = 3, c = 33; int big = a; if (b > big) big = b; if (c > big) big
		 * = c; System.out.println((a>b)?((a>c)?"a":"c"):"b");
		 */

		// Prime number
		/*
		 * int n = 20; for (int i = 2; i <= n; i++) { boolean b = isPrime(i); if (b ==
		 * true) System.out.print(i); }
		 */
		
		//Factorial
		/*
		 * int n=5; int s=1; for (int i = 1; i <=n; i++) { s=i*s; }
		 * System.out.println(s);
		 */
		
		//Fibonacci series
		/*
		 * int n=7,f=0,s=1,t=0; for (int i = 2; i <=n; i++) { t=f+s;
		 * System.out.print(t); f=s; s=t;
		 * 
		 * }
		 */
		
		int d=123;
		System.out.println(d%10);
		
		
		
		
		
	}

	/*
	 * public static boolean isPrime(int n) { for (int i = 2; i <= n / 2; i++) { if
	 * (n % i == 0) return false; } return true; }
	 */

}
