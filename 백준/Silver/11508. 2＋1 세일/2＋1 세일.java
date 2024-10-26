import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> ad = new ArrayList();
		
		for (int i = 0; i < N; i++) {
			int C = Integer.parseInt(br.readLine());
			ad.add(C);
		}
		
		int answer = 0;
		
		Collections.sort(ad);
		
		while (ad.size() >= 3) {
			int a = ad.remove(ad.size() - 1);
			int b = ad.remove(ad.size() - 1);
			int c = ad.remove(ad.size() - 1);
			
			answer += a + b;
		}
		
		while (!ad.isEmpty()) {
			answer += ad.remove(0);
		}
		
		System.out.println(answer);
	}
}
