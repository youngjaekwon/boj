package q15686;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int hCount = 0;
		int cCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					hCount++;
				} else if (map[i][j] == 2) {
					cCount++;
				}
			}
		}

		String[] chicken = new String[cCount];
		boolean[] visited = new boolean[cCount];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					chicken[index] = i + "," + j;
					index++;
				}
			}
		}

		int cases = combination(cCount, M);
		String str = "";

		str = comb(chicken, str, visited, 0, cCount, M);
		
		String[] combinations = str.split("/");

		int[] chickenDistances = new int[combinations.length];
		int count = 0;

		for (int k = 0; k < combinations.length; k++) {
			int[] xhouses = new int[hCount];
			int[] yhouses = new int[hCount];
			int[] xchicken = new int[M];
			int[] ychicken = new int[M];
			int hIndex = 0;

			String[] chickencoordinate = combinations[k].split(" ");

			for (int i = 0; i < M; i++) {
				String[] temp = chickencoordinate[i].split(",");
				xchicken[i] = Integer.parseInt(temp[0]);
				ychicken[i] = Integer.parseInt(temp[1]);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						xhouses[hIndex] = i;
						yhouses[hIndex] = j;
						hIndex++;
					}
				}
			}

			int[][] distanceofChicken = new int[hCount][M];

			for (int i = 0; i < hCount; i++) {
				for (int j = 0; j < M; j++) {
					int distance = Math.abs(xhouses[i] - xchicken[j]) + Math.abs(yhouses[i] - ychicken[j]);
					distanceofChicken[i][j] = distance;
				}
			}

			int[] chickenDistance = new int[hCount];

			for (int i = 0; i < hCount; i++) {
				Arrays.sort(distanceofChicken[i]);
				chickenDistance[i] = distanceofChicken[i][0];
			}

			int cd = 0;

			for (int i = 0; i < hCount; i++) {
				cd += chickenDistance[i];
			}

			chickenDistances[k] = cd;

		}
		
		Arrays.sort(chickenDistances);
		
		System.out.println(chickenDistances[0]);

	}

	static int factorial(int x) {
		int res = 1;
		for (int i = 1; i <= x; i++) {
			res *= i;
		}
		return res;
	}

	static int combination(int n, int k) {
		return factorial(n) / factorial(k) * factorial(n - k);
	}

	static String print(String[] arr, String str, boolean[] visited) {
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == true) {
					str += arr[i] + " ";
			}
		}
		str = str.substring(0, str.length() - 1);
		str += "/";
		return str;
	}
    
    static String comb(String[] arr, String str, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
        	str = print(arr, str, visited);
            return str;
        }
        
        if (depth == n) {
            return str;
        }

        
        visited[depth] = true;
        str = comb(arr, str, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        str = comb(arr, str, visited, depth + 1, n, r);
        
        return str;
    }

}
