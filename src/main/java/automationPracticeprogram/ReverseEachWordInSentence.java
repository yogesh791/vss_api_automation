package automationPracticeprogram;

public class ReverseEachWordInSentence {
	
	public static void main(String[] args) {
		
		String str="I am learning java";
		String[] arr=str.split(" ");
		String strRev="";
		
		for(int i=arr.length-1;i>=0;i--) {
			strRev=strRev+arr[i]+" ";
		}
		
		int len=strRev.length();
		String rev="";
		for(int i=len-1;i>=0;i--) {
			rev=rev+strRev.charAt(i);
		}
		System.out.println(rev);
		
	}

}
