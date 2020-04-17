package programmingPrctice;

public class RemoveJunkFromString {
	
	public static void main(String[] args) {
		
		String s="会意字 testing 指事字 %&*&^%%$%^^& selenium 會意字";
		
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		
		System.out.println(s);
		
	}

}
