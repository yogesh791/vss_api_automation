package programmingPrctice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateElementInArray {

	public static void main(String[] args) {

		// Method 1

		String names[] = { "Java", "JavaScript", "python", "Ruby", "C", "Java","JavaScript" };

		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {
				if (names[i].equals(names[j])) {
					System.out.println("Duplicate element is: " + names[i]);
				}
			}
		}
		System.out.println("**************************************");

		// Using HashSet

		Set<String> store = new HashSet<String>();
		for (String name : names) {
			if (store.add(name) == false) {
				System.out.println("Duplicate element is through method 2:: " + name);
			}
		}
		
		System.out.println("**************************************");

		// Using HashMap

		Map<String , Integer> storeMap=new HashMap<String, Integer>();
		for(String name: names) {
			Integer count=storeMap.get(name);
			if(count == null) {
				storeMap.put(name, 1);
			}
			else {
				storeMap.put(name, ++count);
			}
		}
		
		Set<Entry<String, Integer>> entrySet=storeMap.entrySet();
		for(Entry<String, Integer> entry:entrySet) {
			if(entry.getValue()>1) {
				System.out.println("Duplicate element is through HashMap::"+entry.getKey());
			}
		}

	}

}
