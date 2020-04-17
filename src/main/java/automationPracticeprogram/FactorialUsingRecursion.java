package automationPracticeprogram;

public class FactorialUsingRecursion {
	
	public static void main(String[] args) {
		
		System.out.println("Factorial is: "+findFactorial(5));
		
		
	}
	
	public static int findFactorial(int num) {
		if(num<=1) {
			return 1;
		}else {
			return num*findFactorial(num-1);
		}
		
	}
}
