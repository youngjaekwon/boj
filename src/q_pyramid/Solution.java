package q_pyramid;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = solution(enroll, referral, seller, amount);


        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> bosses = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            String mem = enroll[i];
            String boss = referral[i];

            bosses.put(mem, boss);

            resultMap.put(mem, 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String mem = seller[i];
            int amount_origin = amount[i];
            int result = amount_origin * 100;

            result_to_boss(bosses, resultMap, mem, result);
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            String mem = enroll[i];
            answer[i] = resultMap.get(mem);
        }

        return answer;
    }

    public static void result_to_boss(Map<String, String> bosses, Map<String, Integer> resultMap, String mem, int result){
        double result_boss_double = result * 0.1;
        int result_boss = (int) result_boss_double;
        if (result_boss_double < 1) {
            resultMap.put(mem, resultMap.get(mem) + result);
        } else {
            resultMap.put(mem, resultMap.get(mem) + result - result_boss);
            String boss = bosses.get(mem);
            if (boss.equals("-")) return;
            if (result_boss == 1){
                resultMap.put(boss, resultMap.get(boss) + result_boss);
                return;
            }
            result_to_boss(bosses, resultMap, boss, result_boss);
        }
    }
}