package automationPracticeprogram;

public class FibonacciUsingRecursion {
	
	static int first=0,second=1,third;
	
	public static void main(String[] args) {
		
		printFibonacci(10);
		
	}
	
	public static void printFibonacci(int num) {
		if(num>=1) {
			System.out.print(first+" ");
			third=first+second;
			first=second;
			second=third;
			printFibonacci(num-1);
		}
	}

}
