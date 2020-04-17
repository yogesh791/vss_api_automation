package programmingPrctice;

public class ReverseAString {
	
	public static void main(String[] args) {
		
		//Using for loop
		
		String s="Hello World";
		int len=s.length();
		String rev="";
		for(int i=len-1;i>=0;i--) {
			rev=rev+s.charAt(i);
		}
		System.out.println(rev);
		
		//Using StringBuffer
		StringBuffer sb=new StringBuffer(s);
		System.out.println(sb.reverse());
		
	}

}
