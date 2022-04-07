package programers.q_report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<List<String>> reportCountList = new ArrayList<>();
        List<String> idList = Arrays.asList(id_list);
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            reportCountList.add(new ArrayList<>());
            answerList.add(0);
        }

        for (String eachReport:report){
            String reporter = eachReport.split(" ")[0];
            String target = eachReport.split(" ")[1];

            int targetIndex = idList.indexOf(target);
            List<String> targetReportCount = reportCountList.get(targetIndex);
            if (!targetReportCount.contains(reporter)){
                targetReportCount.add(reporter);
            }
        }

        for (List<String> reportCount:reportCountList){
            if (reportCount.size() >= k){
                for (String reporter:reportCount){
                    int reporterIndex = idList.indexOf(reporter);
                    answerList.set(reporterIndex, answerList.get(reporterIndex) + 1);
                }
            }
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
