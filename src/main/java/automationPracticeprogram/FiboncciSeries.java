package automationPracticeprogram;

public class FiboncciSeries {

	public static void main(String[] args) {

		int first = 0;
		int second = 1;
		int n = 10;

		for (int i = 0; i <= n; i++) {
			System.out.print(first + " ");
			int third = first + second;
			first = second;
			second = third;
		}

	}

}
