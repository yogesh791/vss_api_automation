package automationPracticeprogram;

import java.util.Arrays;

public class CheckAnagram {
	
	public static void main(String[] args) {
		
		String str1="pots";
		String str2="tops";
		
		char[] arr1=str1.toLowerCase().toCharArray();
		char[] arr2=str2.toLowerCase().toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1, arr2)) {
			System.out.println("Given strings are anagram");
		}else {
			System.out.println("Given strings are not anagram");
		}
	}

}
