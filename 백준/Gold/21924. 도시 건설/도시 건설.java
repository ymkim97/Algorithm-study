import java.util.*;
import java.io.*;

class Main {
	
	static ArrayList<Node> nodes = new ArrayList<>();
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long firstCost = 0;
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	firstCost += cost;
        	
        	nodes.add(new Node(a, b, cost));
        }
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        
        Collections.sort(nodes, (a, b) -> a.cost - b.cost);
        
        long minCost = 0;
        int count = 0;
        for (Node n : nodes) {
        	if (parent(n.a) != parent(n.b)) {
        		union(n.a, n.b);
        		minCost += n.cost;
        		count += 1;
        		if (count == N - 1) break;
        	}
        }
        
        System.out.println(count != N - 1 ? -1 : firstCost - minCost);
	}
	
	public static int parent(int n) {
		if (parent[n] == n) return n;
		
		return parent[n] = parent(parent[n]);
	}
	
	public static void union(int a, int b) {
		int aParent = parent(a);
    	int bParent = parent(b);
    	
    	if(bParent < aParent) parent[aParent] = bParent;
    	else if (bParent > aParent) parent[bParent] = aParent;
	}
	
	static class Node {
		int a;
		int b;
		int cost;
		
		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}