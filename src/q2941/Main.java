package q2941;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				if ((s.charAt(i) == 'c') && (s.charAt(i + 1) == '-'))
					count--;
				else if ((s.charAt(i) == 'c') && (s.charAt(i + 1) == '='))
					count--;
				else if ((s.charAt(i) == 'd') && (s.charAt(i + 1) == '-'))
					count--;
				else if ((s.charAt(i) == 'l') && (s.charAt(i + 1) == 'j'))
					count--;
				else if ((s.charAt(i) == 'n') && (s.charAt(i + 1) == 'j'))
					count--;
				else if ((s.charAt(i) == 's') && (s.charAt(i + 1) == '='))
					count--;
				else if ((s.charAt(i) == 'z') && (s.charAt(i + 1) == '='))
					count--;
			}
			if (i + 2 < s.length()) {
				if ((s.charAt(i) == 'd') && (s.charAt(i + 1) == 'z') && (s.charAt(i + 2) == '=')) {
					count--;
				}
			}
			count++;
		}

		System.out.println(count);

	}

}
