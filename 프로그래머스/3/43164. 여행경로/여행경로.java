import java.util.*;

class Solution {
    
    Map<String, Queue<String>> graph = new HashMap<>();
    
    public String[] solution(String[][] tickets) {        
        for (String[] ticket : tickets) { // 각 출발지로부터 도착지로 알파벳 순서로 저장
            String from = ticket[0];
            String to = ticket[1];
            
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            
            graph.get(from).offer(to);
        }

        return dfs("ICN").toArray(new String[0]);
    }
    
    public Deque<String> dfs(String key){
        if(!graph.containsKey(key) || graph.get(key).isEmpty()){
            return new LinkedList<>(List.of(key));
        }

        Deque<String> right = dfs(graph.get(key).poll());
        
        if(!graph.get(key).isEmpty()){
            
            Deque<String> left = dfs(graph.get(key).poll());
            
            if(left.size() > right.size()){
                while(!right.isEmpty()){
                    left.addLast(right.pollFirst());
                }
                right = left;
            }
            
            else {
                while(!left.isEmpty()){
                    right.addFirst(left.pollLast());
                }
            }
        }
        right.addFirst(key);
        
        return right;
    }
}