package programers.q_camouflage;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"코트", "옷"}};
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] item : clothes){
            String name = item[0];
            String genre = item[1];

            Integer numofGenre = clothesMap.get(genre);
            if (numofGenre != null) {
                clothesMap.put(genre, ++numofGenre);
            }
            else {
                numofGenre = 1;
                clothesMap.put(genre, numofGenre);
            }
        }

        int count = 0;
        int div = 1;
        Iterator<String> iterator = clothesMap.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            int thisGenreNum = clothesMap.get(key);
            count += thisGenreNum;

            div *= thisGenreNum;
            if (clothesMap.size() != 1) count += div;
        }

        System.out.println(count);

    }

    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] item : clothes){
            String name = item[0];
            String genre = item[1];

            Integer numofGenre = clothesMap.get(genre);
            if (numofGenre != null) {
                clothesMap.put(genre, ++numofGenre);
            }
            else {
                numofGenre = 1;
                clothesMap.put(genre, numofGenre);
            }
        }

        int div = 1;
        Iterator<String> iterator = clothesMap.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            int thisGenreNum = clothesMap.get(key);
            answer += thisGenreNum;

            div *= thisGenreNum;
            if (clothesMap.size() != 1) answer += div;
        }

        return answer;
    }
}
