import java.util.*;
import java.io.*;

public class Main {
	
	static long A;
	static long B;
	static long answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		dfs(4);
		dfs(7);
		
		System.out.println(answer);
	}
	
	public static void dfs(long num) {
		if (num > B) return;
		
		if (num >= A) answer += 1;
		
		dfs(num * 10 + 4);
		dfs(num * 10 + 7);
	}
}
