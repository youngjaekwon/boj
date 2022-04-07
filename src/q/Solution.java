package q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        List<Integer> resultList = new ArrayList<>();
        int answer = 1;
        if (citations.length > 1){
            for (int i = 1; i <= citations.length; i++) {
                int count = 0;
                for (int citation : citations) {
                    if (citation >= i) count++;
                }
                if (count >= i) resultList.add(i);
            }
            if (!resultList.isEmpty()) answer = Collections.max(resultList);
            else answer = 0;
        }
        return answer;
    }
}
