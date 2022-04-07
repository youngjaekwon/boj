package programers.q_bestAlbum;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 800, 800, 2500};

        int[] answer = solution(genres, plays);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Map<String, Integer>> genresMap = new HashMap<>();
        Map<String, Integer> totalPlay = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Map<String, Integer> musics = genresMap.get(genre);
            if (musics == null){
                Map<String, Integer> newMusics = new HashMap<>();
                newMusics.put(i + "", plays[i]);
                genresMap.put(genre, newMusics);
            } else {
                musics.put(i + "", plays[i]);
                genresMap.put(genre, musics);
            }

            if (totalPlay.get(genre) != null){
                totalPlay.put(genre, totalPlay.get(genre) + plays[i]);
            } else totalPlay.put(genre, plays[i]);
        }

        String[] totalPlayArray = sortHashMap(totalPlay);

        List<Integer> resultList = new ArrayList<>();

        for (String genre : totalPlayArray){
            Map<String, Integer> musics = genresMap.get(genre);
            String[] musicsArray = sortHashMap(musics);
            resultList.add(Integer.parseInt(musicsArray[0]));
            if (musicsArray.length > 1) {
                resultList.add(Integer.parseInt(musicsArray[1]));
            }
        }

        int[] answer = resultList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static String[] sortHashMap(Map<String, Integer> hashMap){
        String[] result = new String[hashMap.size()];
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(hashMap.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                } else return o2.getValue().compareTo(o1.getValue());
            }
        };

        Collections.sort(entries, comparator);
        int index = 0;
        for (Map.Entry<String, Integer> entry : entries){
            result[index] = entry.getKey();
            index++;
        }
        return result;
    }

//    public static String[] sortHashMap(Map<String, Integer> hashMap){
//        List<Integer> values = new ArrayList<>();
//        Iterator<String> keys = hashMap.keySet().iterator();
//        String[] result = new String[hashMap.size()];
//
//        while (keys.hasNext()){
//            String key = keys.next();
//            int value = hashMap.get(key);
//            values.add(value);
//        }
//
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        };
//
//        values.sort(comparator);
//
//        for (int i = 0; i < values.size(); i++) {
//            int value = values.get(i);
//            Iterator<String> newKeys = hashMap.keySet().iterator();
//            while (newKeys.hasNext()){
//                String key = newKeys.next();
//                Integer hashMapVal = hashMap.get(key);
//                if (value == hashMapVal){
//                    result[i] = key;
//                }
//            }
//        }
//
//        return result;
//    }
}
