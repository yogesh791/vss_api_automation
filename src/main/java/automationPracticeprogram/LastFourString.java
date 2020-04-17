package automationPracticeprogram;

public class LastFourString {
	
	public static void main(String[] args) {
		
		String str="www.facebook.com";
		
		String firstFour=str.substring(0, 4);
		System.out.println(firstFour);
		
		String lastFour=str.substring(str.length()-4, str.length());
		System.out.println(lastFour);
		
		String websiteName=str.substring(4, str.length()-4);
		System.out.println(websiteName);
	}

}
