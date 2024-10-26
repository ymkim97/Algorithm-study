import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String ori = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			
			int oriIdx = 0;
			boolean flag = false;
			
			for (int j = 0; j < s.length(); j++) {
				if (ori.charAt(oriIdx) == s.charAt(j)) {
					oriIdx += 1;
					if (oriIdx == ori.length()) {
						sb.append("true").append("\n");
						flag = true;
						break;
					}
				}
			}
			
			if (!flag) sb.append("false").append("\n");
		}
		
		System.out.println(sb);
	}
}
