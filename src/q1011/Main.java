package q1011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = end - start;
            double root = Math.sqrt((double) (end - start));
            int boost = 1;
            int count = 0;
            int upper = (int)root - 1;
            int remain_upper = distance - (upper * (upper + 1) + (int)root);
            count = upper * 2 + remain_upper + 1;
//            while(true){
//                distance -= boost;
//                boost++;
//                count++;
//                if ((int) root == boost) break;
//            }
//            while (distance > 0){
//                if(distance == 1){
//                    count++;
//                    break;
//                }
//                distance -= boost;
//                if(boost > 1) boost--;
//                count++;
//            }
            System.out.println(count);
        }
    }
    static int isBreak(int i){
        int res = 0;
        while(i > 0){
            res += i--;
        }
        return res;
    }

}
