package LearningJavaProgram;

public class PrimeNum {

	public static void main(String[] args) {
		// To check whether given number is prime or not
		int c=20;
		Boolean res=isPrime(c);
		System.out.println(res);
	}

	public static Boolean isPrime(int n) {
		if(n==0 || n==1)
		return false;
		if(n==2)
			return true;
		for (int i = 2; i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

}
