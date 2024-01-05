package LearningJavaProgram;

public class CustomException {

	public static void main(String[] args) {

		int age = 10;
		try {
			if (age < 18)
				throw new customExp("Age Must be greater than 18");
			else
				System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("done");
	}

}

class customExp extends RuntimeException {
	public customExp(String message) {
		super(message);
	}
}
