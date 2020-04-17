package automationPracticeprogram;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		
		int fact=1;
		
		System.out.println("Enter the number for factorial: ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		for(int i=num;i>=1;i--) {
			fact=fact*i;
		}
		
		System.out.println("The factorial of "+num+" is "+fact);
		
	}

}
