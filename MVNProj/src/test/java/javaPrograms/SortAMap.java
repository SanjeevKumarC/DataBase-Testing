package javaPrograms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortAMap {
	String name;
	int id;
public SortAMap(String s,int i) {
	name=s;
	id=i;
}
public String toString() {
	return "[Name = "+name+" Id = "+id+"]";
}
	public static void main(String[] args) {
		HashMap<String, Integer> emp = new HashMap<>();
		emp.put("aaa", 1);emp.put("ttt", 5);emp.put("vvv", 4);emp.put("ccc", 3);emp.put("sss", 1);
		//System.out.println(emp);
		// emp.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		//emp.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		
		Map<Object, Integer> mp=new LinkedHashMap<>();
		mp.put(new SortAMap("aaa",1), 99);
		mp.put(new SortAMap("ccc",4), 96);
		mp.put(new SortAMap("bbb",2), 97);
		mp.put(new SortAMap("yyy",3), 93);
		System.out.println(mp);
		//Collections.sort(al, (SortACollection o1, SortACollection o2) -> {return o1.fname.compareTo(o2.fname);});
		//Collections.sort(mp,(SortAMap s1,SortAMap s2)->{return s1.name.compareTo(s2.name);});
		try {
			//mp.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(entry -> entry.getKey().name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
