package LearningJavaProgram;

public class palindrome {

	public static void main(String[] args) {
		String r = "maday";
		Boolean b = false;
		for (int i = 0; i < r.length(); i++) {
			if (r.charAt(i) != r.charAt(r.length() - i - 1))
				b = false;
			else
				b = true;
		}
		System.out.println(b);
	}

}
