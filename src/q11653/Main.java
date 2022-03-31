package q11653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n != 1) {
            div(n);
        }


    }

    static void div(int x){
        int d = findDecimal(x);
        if (d == -1){
            System.out.println(x);
            return;
        }
        System.out.println(d);
        div(x / d);
    }

    static int findDecimal(int x){
        for(int i = 2; i < x; i++){
            if (x % i == 0) return i;
        }
        return -1;
    }
}
