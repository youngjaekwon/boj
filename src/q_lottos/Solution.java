package q_lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> lottosList = new ArrayList<>();
        List<Integer> win_numsList = new ArrayList<>();
        for (int lottosNum : lottos){
            lottosList.add(lottosNum);
        }
        for (int win_num : win_nums){
            win_numsList.add(win_num);
        }

        int zeroCount = 0; // 0의 갯수
        int min = 0; // 맞춘 번호 갯수

        for (Integer lottosNum : lottosList){
            if (win_numsList.contains(lottosNum)) min++;
            if (lottosNum == 0) zeroCount++;
        }

        int max = min + zeroCount;

        List<Integer> result = new  ArrayList<Integer>(Arrays.asList(6, 5, 4, 3, 2, 1));

        if (result.contains(max)){
            answer[0] = result.indexOf(max) + 1;
        } else answer[0] = 6;

        if (result.contains(min)){
            answer[1] = result.indexOf(min) + 1;
        } else answer[1] = 6;

        return answer;
    }
}
