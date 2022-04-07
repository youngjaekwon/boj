package programers.q_zipString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String s) {
        List<Integer> resultList = new ArrayList<>();

        int originalLen = s.length();

        if (s.length() == 1) resultList.add(1);
        for (int i = 1; i <= s.length() / 2; i++){
            resultList.add(slice(s, i, originalLen).length());
        }

        int answer = Collections.min(resultList);
        return answer;
    }

    public static String slice (String target, int len, int originalLen){
        if (target.length() < len * 2 || target.isEmpty()) return target;

        String result = "";
        int duplication = 1;
        int startIndex = 0;
        int endIndex = len;
        String startChar = target.substring(0, len);
        while (true){
            if (target.length() < endIndex + len) break;
            String start = target.substring(startIndex, endIndex);
            String next = target.substring(startIndex + len, endIndex + len);
             if (start.equals(next)){
                 duplication++;
                 startIndex += len;
                 endIndex += len;
             } else break;
        }

        if (duplication != 1){
            result = duplication + target.substring(0, len);
            String nextTarget = target.substring(len * duplication);
            return result + slice(nextTarget, len, originalLen);
        } else {
                String nextTarget = target.substring(len);
                return startChar + slice(nextTarget, len, originalLen);
        }
    }
}
