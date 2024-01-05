package LearningJavaProgram;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseArrayList {

	public static void main(String[] args) {
		//reverse a linked list in Java
		
		LinkedList li=new LinkedList<>(Arrays.asList(5,4,3,2,1));
		System.out.println(li);
		
		  Iterator it=li.descendingIterator();//descending iterator 
		  it.forEachRemaining(System.out::print);
		 
		/*ListIterator itr=li.listIterator();
		while (itr.hasNext()) {
			Object object = (Object) itr.next();
			
		}
		while (itr.hasPrevious()) {
		System.out.println(itr.previous());
			
		}*/
		

	}

}
