import java.util.*;
import java.io.*;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(M, new ArrayList<>(), arr);
        
        System.out.println(sb.toString());
	}
	
	public static void dfs(int maxDepth, List<Integer> tmp, int[] arr) {
		if (tmp.size() == maxDepth) {
			for (int t : tmp) {
				sb.append(t).append(" ");
			}
			
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			tmp.add(arr[i]);
			dfs(maxDepth, tmp, arr);
			tmp.remove(tmp.size() - 1);
		}
	}
}