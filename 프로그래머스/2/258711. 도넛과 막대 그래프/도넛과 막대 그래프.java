import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4]; // 생성, 도넛, 막대, 8자
        List<Integer>[] in = new ArrayList[1_000_001]; // 해당 edge에서 나가는 쪽
        List<Integer>[] out = new ArrayList[1_000_001]; // 해당 edge에 들어오는 쪽
        Set<Integer> edgeTypes = new HashSet<>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            edgeTypes.add(from);
            edgeTypes.add(to);
            
            if (out[from] == null) out[from] = new ArrayList<>();
            if (in[to] == null) in[to] = new ArrayList<>();
            if (in[from] == null) in[from] = new ArrayList<>();
            if (out[to] == null) out[to] = new ArrayList<>();
            
            out[from].add(to);
            in[to].add(from);
        }
        
        int totalTypes = 0;
        for (int e : edgeTypes) { // 생성한 정점 찾기 - 두개 이상 out, 0개 in
            if (in[e].size() == 0 && out[e].size() >= 2) {               
                answer[0] = e;
                for (int tmp : out[e]) { // 끊어주기
                    totalTypes += 1;
                    in[tmp].remove(Integer.valueOf(e));
                }
                edgeTypes.remove(e);
                break;
            }
        }
        
        int tmp = 0;
        for (int e : edgeTypes) { // 8자 찾기
            if (in[e].size() == 2 && out[e].size() == 2) {
                tmp += 1;
            }
        }
        
        answer[3] = tmp;
        
        tmp = 0;
        for (int e : edgeTypes) { // 막대 찾기
            if (in[e].size() == 0) {
                tmp += 1;
            }
        }
        
        answer[2] = tmp;
        answer[1] = totalTypes - (answer[2] + answer[3]);
        
        return answer;
    }
}