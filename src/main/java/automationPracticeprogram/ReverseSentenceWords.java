package automationPracticeprogram;

public class ReverseSentenceWords {
	
	public static void main(String[] args) {
		
		String str="I am learning Java";
		
		String[] arr=str.split(" ");
		String rev="";
		for(int i=arr.length-1;i>=0;i--) {
			rev=rev+arr[i]+" ";
		}
		
		System.out.println(rev);
		
	}

}
