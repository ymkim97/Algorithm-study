import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int size = 100001;
        int[] visited = new int[size];
        Arrays.fill(visited, -1);
        visited[N] = 0;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(N);
        
        while (!q.isEmpty()) {
        	int now = q.removeFirst();
        	
        	if (now == K) {
        		System.out.println(visited[now]);
        		break;
        	}
        	
        	if (now * 2 < size && visited[now * 2] == -1) {
        		visited[now * 2] = visited[now];
        		q.addFirst(now * 2);
        	}
        	
        	if (now - 1 >= 0 && visited[now - 1] == -1) {
        		visited[now - 1] = visited[now] + 1;
        		q.addLast(now - 1);
        	}
        	
        	if (now + 1 < size && visited[now + 1] == -1) {
        		visited[now + 1] = visited[now] + 1;
        		q.addLast(now + 1);
        	}
        }
	}
}
