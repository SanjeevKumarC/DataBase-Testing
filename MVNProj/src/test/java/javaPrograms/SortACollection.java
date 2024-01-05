package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class SortACollection {
	private static final Logger logger = Logger.getLogger(SortACollection.class.getName());
	int id, mark;
	String fname, lname;

	public SortACollection(int id, String fname, String lname, int mark) {
		super();
		this.id = id;
		this.mark = mark;
		this.fname = fname;
		this.lname = lname;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", mark=" + mark + ", fname=" + fname + ", lname=" + lname + "] ";
	}

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<>(Arrays.asList("aa", "ggg", "e", "bbb"));
		// System.out.println(l);
		// Sort using comparator
		Comparator<String> len = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
				// Integer.compare(s1.length(), s2.length());sort by number of char
			}
		};
		Collections.sort(l);
		System.out.println(l);

//		List<SortACollection> al = new ArrayList<>();
//		al.add(new SortACollection(23, "sanjeev", "kumar", 90));
//		al.add(new SortACollection(22, "ramesh", "raj", 60));
//		al.add(new SortACollection(25, "arun", "arun", 80));
//		al.forEach(System.out::println);
//		Collections.sort(al, (SortACollection o1, SortACollection o2) -> {return o1.fname.compareTo(o2.fname);});
//		System.out.println("SORT BY NAME");
//		//logger.warning("SORT BY NAME");
//		al.forEach(System.out::println);
//		System.out.println("SORT BY MARK");
//		Collections.sort(al,(SortACollection s1 , SortACollection s2)->{return Integer.compare(s1.mark,s2.mark);});
//		al.forEach(System.out::println);

	}

}
