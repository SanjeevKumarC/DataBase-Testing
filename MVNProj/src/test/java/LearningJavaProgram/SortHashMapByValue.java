package LearningJavaProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapByValue {

	public static void main(String[] args) {
		// sorts HashMap by value.

		HashMap<String, Integer> scores = new HashMap<>();
		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);
      //Linkedhashmap for maintain the insertion order
		Map<String, Integer> sortedByValue = new LinkedHashMap<>();

		// create a list since the set is unordered
		List<Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
		System.out.println(entryList);

		// sort the list by value
		entryList.sort((x, y) -> x.getKey().compareTo(y.getKey()));
		System.out.println(entryList);

		// populate the new hash map
		for (Entry<String, Integer> entry : entryList) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}

		System.out.println(sortedByValue);
	}

}
