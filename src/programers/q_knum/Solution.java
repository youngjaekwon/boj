package programers.q_knum;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int [] array2 = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(array2);
            answer[i] = array2[commands[i][2] - 1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int i = 0;

        for (int[] command:commands){
            List<Integer> list = new ArrayList<>();

            for (int num : array){
                list.add(num);
            }

            int startIndex = command[0] - 1;
            int endIndex = command[1];
            int k = command[2] - 1;

            List<Integer> arrayByCommand = list.subList(startIndex, endIndex);
            arrayByCommand.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            int targetNum = arrayByCommand.get(k);
            answer[i++] = targetNum;
        }

        return answer;
    }
}
