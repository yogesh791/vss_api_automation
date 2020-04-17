package automationPracticeprogram;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterOccurance {

	public static void main(String[] args) {
		
		String str="lallantop show";
		
		char[] ch=str.toCharArray();
		
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		int count=1;
		for(int i=0;i<ch.length;i++) {
			if(!map.containsKey(ch[i])) {
				map.put(ch[i], count);
			}else {
				map.put(ch[i], map.get(ch[i])+1);
			}
		}
		
		for(Character c:map.keySet()) {
			System.out.println("Count of character \""+c+"\" is:"+map.get(c));
		}
	}
	
}
