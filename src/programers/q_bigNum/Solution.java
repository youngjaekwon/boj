package programers.q_bigNum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        List<String> numbersList = new ArrayList<>();
        for (int number : numbers){
            numbersList.add(number + "");
        }

        numbersList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int startO1 = Integer.parseInt(o1.charAt(0) + "");
                int startO2 = Integer.parseInt(o2.charAt(0) + "");

                if (startO1 == startO2){
                    Integer num1 = Integer.parseInt(o1 + o2);
                    Integer num2 = Integer.parseInt(o2 + o1);
                    return num2.compareTo(num1);
                }

                return o2.compareTo(o1);
            }
        });

        StringBuilder answerSB = new StringBuilder();

        for (String num : numbersList){
            answerSB.append(num);
        }

        String answer = answerSB.toString();

        if (answer.replace("0", "").isEmpty()) answer = "0";

        return answer;
    }
}
