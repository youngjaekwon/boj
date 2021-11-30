package q14503;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 세로크기
		int M = sc.nextInt(); // 가로크기

		// 로봇 청소기가 있는 장소
		int[][] spaces = new int[N][M]; // N * M

		// 로봇 청소기의 좌표 (r, c)
		int r = sc.nextInt();
		int c = sc.nextInt();

		// 방향 입력
		int d = sc.nextInt(); // 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽

		// 지도 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		
		// 0 : 빈칸, 1 : 벽, 2 : 청소됨

		// 청소하는 칸의 개수
		int count = 1;
		spaces[r][c] = 2;
		while (true) {
			if (d == 0) {
				if (((spaces[r - 1][c] == 1) || (spaces[r - 1][c] == 2))
						&& ((spaces[r][c - 1] == 1) || (spaces[r][c - 1] == 2))
						&& ((spaces[r][c + 1] == 1) || (spaces[r][c + 1] == 2))
						&& ((spaces[r + 1][c] == 1) || (spaces[r + 1][c] == 2))) {
					if (spaces[r + 1][c] == 1) {
						break;
					} else if (spaces[r + 1][c] == 2) {
						r += 1;
					}
				} else {
					if (spaces[r][c - 1] == 0) {
						d = 3;
						spaces[r][c - 1] = 2;
						c -= 1;
						count++;
					} else {
						d = 3;
					}
				}
			} else if (d == 1) {
				if (((spaces[r][c + 1] == 1) || (spaces[r][c + 1] == 2))
						&& ((spaces[r - 1][c] == 1) || (spaces[r - 1][c] == 2))
						&& ((spaces[r + 1][c] == 1) || (spaces[r + 1][c] == 2))
						&& ((spaces[r][c - 1] == 1) || (spaces[r][c - 1] == 2))) {
					if (spaces[r][c - 1] == 1) {
						break;
					} else if (spaces[r][c - 1] == 2) {
						c -= 1;
					}
				} else {
					if (spaces[r - 1][c] == 0) {
						d = 0;
						spaces[r - 1][c] = 2;
						r -= 1;
						count++;
					} else {
						d = 0;
					}
				}
			} else if (d == 2) {
				if (((spaces[r + 1][c] == 1) || (spaces[r + 1][c] == 2))
						&& ((spaces[r][c - 1] == 1) || (spaces[r][c - 1] == 2))
						&& ((spaces[r][c + 1] == 1) || (spaces[r][c + 1] == 2))
						&& ((spaces[r - 1][c] == 1) || (spaces[r - 1][c] == 2))) {
					if (spaces[r - 1][c] == 1) {
						break;
					} else if (spaces[r - 1][c] == 2) {
						r -= 1;
					}
				} else {
					if (spaces[r][c + 1] == 0) {
						d = 1;
						spaces[r][c + 1] = 2;
						c += 1;
						count++;
					} else {
						d = 1;
					}
				}
			} else if (d == 3) {
				if (((spaces[r][c - 1] == 1) || (spaces[r][c - 1] == 2))
						&& ((spaces[r + 1][c] == 1) || (spaces[r + 1][c] == 2))
						&& ((spaces[r - 1][c] == 1) || (spaces[r - 1][c] == 2))
						&& ((spaces[r][c + 1] == 1) || (spaces[r][c + 1] == 2))) {
					if (spaces[r][c + 1] == 1) {
						break;
					} else if (spaces[r][c + 1] == 2) {
						c += 1;
					}
				} else {
					if (spaces[r + 1][c] == 0) {
						d = 2;
						spaces[r + 1][c] = 2;
						r += 1;
						count++;
					} else {
						d = 2;
					}
				}
			}

		}
		System.out.println(count);
	}

}
