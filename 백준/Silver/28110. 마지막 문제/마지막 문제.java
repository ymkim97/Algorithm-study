import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] problems = new int[N];
        
        for (int i = 0; i < N; i++) {
        	problems[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(problems);
        
        int answer = -1;
        
        if (problems[N - 1] - problems[0] + 1 == N) {
        	System.out.println(answer);
        	return;
        }
        
        int maxDiff = 0;
        
        for (int i = 0; i < N - 1; i++) {
        	int median = (problems[i] + problems[i + 1]) / 2;
        	
        	if (median != problems[i] && median != problems[i + 1]) {
        		int diff = Math.min(median - problems[i], problems[i + 1] - median);
        		if (diff > maxDiff) {
        			maxDiff = diff;
        			answer = median;
        		}
        	}
        }
        
        System.out.println(answer);
	}
}
