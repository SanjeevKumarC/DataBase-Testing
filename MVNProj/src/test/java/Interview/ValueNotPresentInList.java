package Interview;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueNotPresentInList {

	public static void main(String[] args) {
		ArrayList al = new ArrayList(Arrays.asList("h", "g", "a", "y"));
		ArrayList aaa=new ArrayList<>(Arrays.asList(1,2,3,4,5));
		aaa.forEach(n->System.out.print(n));
		al.forEach( a-> System.out.print(a));
		String value = "z";
		boolean res = true;
		if (al.contains(value))
			res = false;
		else
			res = true;

		System.out.println(res);

	}

}
