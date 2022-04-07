package programers.q_cycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = i * columns + 1; j <= columns * (i + 1); j++) {
                row.add(j);
            }
            map.add(row);
        }

        int[] answer = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int[] querie = queries[k];
            List<Integer> nums = new ArrayList<>();

            int x1 = querie[0] - 1;
            int y1 = querie[1] - 1;
            int x2 = querie[2] - 1;
            int y2 = querie[3] - 1;

            int start = map.get(x1).get(y1);

            for (int i = 0; i < x2 - x1; i++) {
                int num = map.get(x1 + 1 + i).get(y1);
                nums.add(num);
                map.get(x1 + i).set(y1, num);
            }

            for (int i = 0; i < y2 - y1; i++) {
                int num = map.get(x2).get(y1 + 1 + i);
                nums.add(num);
                map.get(x2).set(y1 + i, num);
            }

            for (int i = 0; i < x2 - x1; i++) {
                int num = map.get(x2 - 1 - i).get(y2);
                nums.add(num);
                map.get(x2 - i).set(y2, num);
            }

            for (int i = 0; i < y2 - y1; i++) {
                int num = map.get(x1).get(y2 - 1 - i);
                nums.add(num);
                map.get(x1).set(y2 - i, num);
            }

            map.get(x1).set(y1 + 1, start);
            nums.add(start);

            answer[k] = Collections.min(nums);
        }

        for (List<Integer> row : map ){
            System.out.println(row);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }
}