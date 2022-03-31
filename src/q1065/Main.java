package q1065;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 1000)
			N = 999;
		int count = 0;

		if (N < 100)
			count = N;
		else {
			count = 99;

			for (int i = 100; i <= N; i++) {
				if ((i / 100) - (i % 100 / 10) == (i % 100 / 10) - (i % 10)) {
					count++;
				}
			}
		}

		System.out.println(count);

	}

}
