import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static char[][] res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        res = new char[7][N];
        
        divAndConquer(0, 0, N);
        
        for (int i = 0; i < 7; i++) {
        	if (!Arrays.asList(res[i]).contains("A")) {
        		res[i][0] = 'A';
        	}
        	
        	for (int j = 0; j < N; j++) {
        		System.out.print(res[i][j]);
        	}
        	
        	System.out.println();
        }
	}
	
	public static void divAndConquer(int depth, int start, int end) {
		if (depth == 7) return;
		
		int mid = (start + end) / 2;
		
		for (int i = start; i < mid; i++) {
			res[depth][i] = 'A';
		}
		
		for (int i = mid; i < end; i++) {
			res[depth][i] = 'B';
		}
		
		divAndConquer(depth + 1, start, mid);
		divAndConquer(depth + 1, mid, end);
	}
}