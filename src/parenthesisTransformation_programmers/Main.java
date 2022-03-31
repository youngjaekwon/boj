package parenthesisTransformation_programmers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }
    public static String solution(String p) {
        if (p.isEmpty()) return p;
        return split(p);
    }
    static String split(String s){
        if (s.isEmpty()) return s;

        int endIndex = searchEndIndex(s);

        String u = s.substring(0, endIndex + 1);
        String v = s.substring(endIndex + 1);

        String newV = split(v);

        if(isPerfect(u)) return u + newV;
        else {
            return "(" + newV + ")" + reverse(u.substring(1, u.length() - 1));
        }
    }

    static boolean isPerfect(String s){
        String newS = "";
        if (s.length() > 2){
            newS = s.substring(1, s.length() - 1);
            int count = 0;
            int count2 = 0;
            for (int i = 0; i < newS.length(); i++){
                if (i % 2 == 0 && newS.charAt(i) == '(') count++;
                else if (i % 2 == 1 && newS.charAt(i) == ')') count++;
            }
            for (int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' && i < s.length() / 2 - 1) count2++;
                else if (s.charAt(i) == ')' && i > s.length() / 2) count2++;
            }
            if (count == newS.length() || count2 == newS.length()) newS = toPair(s);
            if (s.charAt(0) == '(' && searchEndIndex(s) == s.length() - 1) return true;
        } else {
            if (s.equals("()")) return true;
            else return false;
        }
        if (s.equals(newS)) return true;
        else return false;
    }

    static String reverse(String s){
        if(s.isEmpty()) return s;
        String newS = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') newS += ')';
            else newS += '(';
        }
        return newS;
    }

    static int searchEndIndex(String s){
        int countOpen = 0;
        int countClose = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '(') countOpen++;
            else if(s.charAt(i) == ')') countClose++;

            if(countOpen == countClose) return i;
        }
        return 0;
    }

    static String toPair(String u){
        if (u.length() != 2){
            String subU = u.substring(1, u.length() - 1);
            String newU = split(subU);
            return "(" + newU + ")";
        } else {
            if (u.equals(")(")) return "()";
            else return u;
        }
    }
}


