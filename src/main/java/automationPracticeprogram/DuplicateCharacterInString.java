package automationPracticeprogram;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterInString {
	
	public static void main(String[] args) {
		
		String str="laptopopopoobhedfghhdghuytrdhhuytrd";
		
		char[] ch=str.toCharArray();
		int count=1;
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<ch.length;i++) {
			if(!map.containsKey(ch[i])) {
				map.put(ch[i], count);
			}else {
				map.put(ch[i], map.get(ch[i])+1);
			}
		}
		
		for(Character key:map.keySet()) {
			if(map.get(key)>1) {
				System.out.println("Duplicate character is::"+key);
			}
		}
		
		
	}

}
