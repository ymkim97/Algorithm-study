import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
        }
        
        // 뱔전소 no.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
        	parent[Integer.parseInt(st.nextToken())] = -1;
        }
        
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	edges.add(new int[] {a, b, w});
        }
        
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        int answer = 0;
        
        for (int[] edge : edges) {
        	int a = edge[0];
        	int b = edge[1];
        	int w = edge[2];
        	
        	if (find(a) != find(b)) {
        		union(a, b);
        		answer += w;
        	}
        }
        
        System.out.println(answer);
    }
    
    private static int find(int x) {
    	if (parent[x] == -1) return -1;
    	
    	if (parent[x] == x) return x;
    	
    	return parent[x] = find(parent[x]);
    }
    
    private static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if (a < b) parent[b] = a;
    	else parent[a] = b;
    }
}
