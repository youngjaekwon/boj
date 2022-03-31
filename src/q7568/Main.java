package q7568;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] weights = new int[num];
		int[] heights = new int[num];
		int[] ranks = new int[num];

		for (int i = 0; i < num; i++) {
			weights[i] = sc.nextInt();
			heights[i] = sc.nextInt();
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (weights[i] < weights[j] && heights[i] < heights[j]) {
					ranks[i]++;
				}
			}
		}

		for (int i = 0; i < num; i++) {
			if (i == num - 1) {
				System.out.print(ranks[i] + 1);
			} else {
				System.out.print(ranks[i] + 1 + " ");
			}
		}

	}

}
