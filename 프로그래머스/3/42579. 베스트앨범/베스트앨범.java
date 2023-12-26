import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) { // 장르마다 plays 누적
            if (!genMap.containsKey(genres[i])) {
                genMap.put(genres[i], plays[i]);
                continue;
            }
            
            genMap.put(genres[i], genMap.get(genres[i]) + plays[i]);
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(genMap.entrySet()); // 장르의 play 횟수 내림차순 정렬
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        for (Map.Entry<String, Integer> entry : entries) {
            
            String genre = entry.getKey();
            
            Map<Integer, Integer> playMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (!genres[i].equals(genre)) {
                    continue;
                }
                
               playMap.put(i, plays[i]);
            }
            
            List<Map.Entry<Integer, Integer>> playMapEntries = new ArrayList<>(playMap.entrySet());
            playMapEntries.sort((o1, o2) -> {
					if (o2.getValue() > o1.getValue())
						return 1;
					else if (o1.getValue() > o2.getValue())
						return -1;
					else {
						if (o1.getKey() > o2.getKey())
							return 1;
						else
							return -1;
					}
				});
            
            int cnt = 0;
            for (Map.Entry<Integer, Integer> playMapEntry : playMapEntries) {
                if (cnt == 2) {
                    break;
                }
                
                answer.add(playMapEntry.getKey());
                cnt += 1;
            }
        }
   
        return answer.stream().mapToInt(a -> a).toArray();
    }
}