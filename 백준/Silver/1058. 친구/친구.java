import java.io.*;
import java.util.*;

class Main {
	
	static int res = 0;
	static int N;
	static int[][] friends;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        friends = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	char[] f = br.readLine().toCharArray();
        	
        	for (int j = 0; j < N; j++) {
        		if (f[j] == 'Y') friends[i][j] = 1;
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	search(i);
        }
        
        System.out.println(res);
    }
    
    public static void search(int start) {
    	Queue<int[]> q = new LinkedList<>();
    	boolean[] visited = new boolean[N];
    	
    	q.offer(new int[] {start, 0});
    	visited[start] = true;
    	int tmp = 0;
    	
    	while (!q.isEmpty()) {
    		int[] now = q.poll();
    		int n = now[0];
    		int cnt = now[1];
    		
    		if (cnt == 2) continue;
    		
    		for (int i = 0; i < N; i++) {
    			if (friends[n][i] == 1 && !visited[i]) {
    				tmp += 1;
    				visited[i] = true;
    				q.offer(new int[] {i, cnt + 1});
    			}
    		}
    	}
    	
    	res = Math.max(res, tmp);
    }
}