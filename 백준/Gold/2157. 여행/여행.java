import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
       
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Point>[] map = new ArrayList[N + 1];
        
        for (int i = 0; i <= N; i++) {
        	map[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	map[from].add(new Point(to, weight));
        }
        
        int[][] dp = new int[M + 1][N + 1];
        
        Queue<int[]> q = new LinkedList<>(); // 0: CityNumber, 1: count
        q.offer(new int[] {1, 1});
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int num = now[0];
        	int count = now[1];
        	
        	if (count + 1 > M) continue;
        	
        	for (Point next : map[num]) {
        		if (next.number < num || dp[count + 1][next.number] >= dp[count][num] + next.value) continue;
        		
        		dp[count + 1][next.number] = dp[count][num] + next.value;
        		q.offer(new int[] {next.number, count + 1});
        	}
        }
        
        int answer = 0;
        
        for (int i = 0; i <= M; i++) {
        	answer = Math.max(answer, dp[i][N]);
        }
        
        System.out.println(answer);
	}
	
	static class Point {
		int number;
		int value;
		
		public Point(int number, int value) {
			this.number = number;
			this.value = value;
		}
	}
}