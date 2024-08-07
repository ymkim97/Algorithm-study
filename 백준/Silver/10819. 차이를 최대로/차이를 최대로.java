import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static int[] numbers;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        numbers = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        backtrack(new ArrayList<>());
        
        System.out.println(answer);
	}
	
	public static void backtrack(List<Integer> lst) {
		if (lst.size() == N) {
			int tmp = 0;
			
			for (int i = 0; i < N - 1; i++) {
				tmp += Math.abs(lst.get(i) - lst.get(i + 1));
			}
			
			answer = Math.max(answer, tmp);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lst.add(numbers[i]);
				backtrack(lst);
				lst.remove(lst.size() - 1);
				visited[i] = false;
			}
		}
	}
}