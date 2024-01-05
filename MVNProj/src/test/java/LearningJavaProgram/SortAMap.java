package LearningJavaProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortAMap {

	public static void main(String[] args) {
		Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 30);
        unsortedMap.put("Alice", 25);
        unsortedMap.put("Bob", 35);
        unsortedMap.put("Eve", 22);

        // Extract entries into a List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(unsortedMap.entrySet());

        // Sort the List by keys
        Collections.sort(entryList, Map.Entry.comparingByValue());

        // Create a LinkedHashMap to maintain the order of sorted entries
        Map<String, Integer> sortedMapByKey = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMapByKey.put(entry.getKey(), entry.getValue());
        }

        // Display the sorted map by keys
        System.out.println(sortedMapByKey);
        
        TreeMap<String, Integer> tm=new TreeMap<>(unsortedMap);
        System.out.println();

	}

}
