package programmingPrctice;

public class ReverseAnInteger {

	public static void main(String[] args) {
		
		// Through algo

		int num = 123456789;
		int rev = 0;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		System.out.println(rev);
		
		//Through StringBuffer
		int num2=67677;
		StringBuffer sb=new StringBuffer(String.valueOf(num2));
		System.out.println(sb.reverse());
	}

}
