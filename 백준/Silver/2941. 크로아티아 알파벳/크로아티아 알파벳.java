import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		
		Set<String> set = new HashSet<>();
		
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");	
		set.add("z=");
		
		int answer = 0;
		int idx = 0;
		
		while (idx < input.length()) {
			
			answer += 1;
			
			if (idx <= input.length() - 3) {
				String two = input.substring(idx, idx + 2);
				String three = input.substring(idx, idx + 3);

				if (set.contains(two)) {
					idx += 2;
				} else if (set.contains(three)) {
					idx += 3;
				} else {
					idx += 1;
				}
			} else if (idx == input.length() - 2) {
				String two = input.substring(idx, idx + 2);
				
				
				if (set.contains(two)) {
					break;
				} else {
					idx += 1;
				}
			} else {
				break;
			}
		}
		
		System.out.println(answer);
	}
}
