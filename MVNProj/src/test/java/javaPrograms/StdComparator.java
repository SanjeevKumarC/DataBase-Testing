package javaPrograms;

import java.util.Comparator;

public class StdComparator implements Comparator<SortACollection> {

	@Override
	public int compare(SortACollection o1, SortACollection o2) {
	
		return o1.fname.compareTo(o2.fname);
	}

}
