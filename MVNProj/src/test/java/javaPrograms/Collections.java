package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;
public class Collections {
	@Test
	 public static void main(String[] args) {
	        int n = 5;
	        int result = factorial(n); // Computes 5! = 5 * 4 * 3 * 2 * 1 = 120
	        System.out.println("Factorial of " + n + " is " + result);
	    }
	    public static int factorial(int n) {
	        // Base case: If n is 0 or 1, return 1
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        // Recursive case: n! = n * (n-1)!
	        else {
	            return n * factorial(n - 1);
	        }
	    }

}
