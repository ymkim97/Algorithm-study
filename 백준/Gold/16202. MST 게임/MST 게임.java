import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<int[]> weights = new LinkedList<>();
		
		for (int i = 1; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			weights.add(new int[] {a, b, i});
		}
		
		int[] answer = new int[K];
		
		boolean isZero = false;
		
		for (int aIdx = 0; aIdx < K; aIdx++) {
			if (isZero) {
				answer[aIdx] = 0;
				continue;
			}
			
			int cost = findMST(N, weights);
			
			if (cost == 0) {
				isZero = true;
				answer[aIdx] = 0;
				continue;
			}
			
			weights.removeFirst();
			answer[aIdx] = cost;
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.printf("%d ", answer[i]);
		}
	}
	
	public static int findMST(int N, LinkedList<int[]> weights) {
		int[] parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		int lineCnt = 0;
		
		for (int[] w : weights) {
			int a = w[0];
			int b = w[1];
			int cost = w[2];
			
			int aParent = find(a, parent);
			int bParent = find(b, parent);
			
			if (aParent != bParent) {
				union(aParent, bParent, parent);
				lineCnt += 1;
				sum += cost;
			}
		}
		
		if (lineCnt != N - 1) return 0;
		
		return sum;
	}
	
	public static int find(int n, int[] parent) {
		if (parent[n] == n) return n;
		
		return find(parent[n], parent);
	}
	
	public static void union(int a, int b, int[] parent) {
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}
}
