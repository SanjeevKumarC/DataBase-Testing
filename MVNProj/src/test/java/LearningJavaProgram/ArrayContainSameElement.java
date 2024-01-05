package LearningJavaProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayContainSameElement {

	public static void main(String[] args) {
		// checks if two arrays contain the same elements
		Integer a[]= {1,2,3,4,5,5,4,8};
		Integer b[]= {1,2,3,5};
	ArrayList<Integer> al1=new ArrayList<Integer>(Arrays.asList(a));
	ArrayList<Integer> al2=new ArrayList<Integer>(Arrays.asList(b));

	System.out.println(al1.containsAll(al2));
	

	}

}
