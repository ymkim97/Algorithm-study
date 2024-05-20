import java.io.*;
import java.util.*;

class Main {
	
	static int[] nums;
	static int N, M;
	static boolean[] visited;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        
        backtrack(0, 0, new ArrayList<>());
    }
    
    public static void backtrack(int depth, int idx, List<Integer> lst) {
    	if (depth == M) {
    		for (int t : lst) System.out.printf("%d ", t);
    		System.out.println();
    		return;
    	}
    	
    	for (int i = idx; i < N; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			lst.add(nums[i]);
    			backtrack(depth + 1, i, lst);
    			visited[i] = false;
    			lst.remove(lst.size() - 1);
    		}
    	}
    }
}