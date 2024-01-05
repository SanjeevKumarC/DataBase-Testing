package LearningJavaProgram;

public class PrintFibonacciRecursive {
//Fibonacci sequence using recursion.
	public static void main(String args[]) {
		int seqLength = 10;
		System.out.print("A Fibonacci sequence of " + seqLength + " numbers: ");

		for (int i = 0; i < seqLength; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	public static int fibonacci(int count) {
		if (count <= 1)
			return count;

		return fibonacci(count - 1) + fibonacci(count - 2);
	}

}
