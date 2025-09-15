import java.util.*;

class Solution {
    
    List<Integer>[] tree;
    int[] idx;
    
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
        
        tree = new ArrayList[n + 1]; // childs for each node
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        idx = new int[n + 1]; // idx for child node (tree)
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            tree[parent].add(child);
        }
        
        for (List<Integer> t : tree) {
            Collections.sort(t);
        }
        
        int[] ballCountForLeafNodes = new int[n + 1];
        List<Integer>[] orders = new ArrayList[n + 1];
        
        boolean isNotAvail = false;
        boolean flag = true;
        
        // 공 넣기
        int step = 0;
        
        while (true) {
            int leaf = getLeafNode(1);

            ballCountForLeafNodes[leaf] += 1;
            
            if (orders[leaf] == null) orders[leaf] = new ArrayList<>();
            orders[leaf].add(step);
            step += 1;
            
            boolean check = true;
            
            for (int i = 1; i <= n; i++) {
                if (ballCountForLeafNodes[i] > target[i - 1]) {
                    isNotAvail = true;
                    break;
                }
                
                if (!(ballCountForLeafNodes[i] <= target[i - 1] && target[i - 1] <= 3 * ballCountForLeafNodes[i])) {
                    check = false; 
                    break;
                }
            }
            
            if (check || isNotAvail) break;
        }
        
        if (isNotAvail) return new int[] {-1};
        
        int answerLength = 0;
        
        for (int i = 1; i <= n; i++) {
            if (ballCountForLeafNodes[i] != 0) {
                answerLength += ballCountForLeafNodes[i];
            }
        }
        
        int[] answer = new int[answerLength];
        
        for (int i = 1; i <= n; i++) {
            if (ballCountForLeafNodes[i] != 0) {
                List<Integer> tmp = makeSequence(ballCountForLeafNodes[i], target[i - 1]);
                
                Collections.sort(tmp);
                
                int tmpIdx = 0;
                for (int idx : orders[i]) {
                    answer[idx] = tmp.get(tmpIdx);
                    tmpIdx += 1;
                }
            }
        }
        
        return answer;
    }
    
    private List<Integer> makeSequence(int count, int target) {
        List<Integer> seq = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            seq.add(1);
        }

        int remain = target - count;
        int idx = 0;
        while (remain > 0) {
            int add = Math.min(2, remain); // 한 공에는 최대 2까지만 더할 수 있음
            seq.set(idx, seq.get(idx) + add);
            remain -= add;
            idx++;
        }
    return seq;
}

    
    private int getLeafNode(int node) {
        if (tree[node].isEmpty()) {
            return node;
        }
        
        int nextNode = tree[node].get(idx[node]);
        idx[node] = (idx[node] + 1) % tree[node].size();
        
        return getLeafNode(nextNode);
    }
}