import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        int[] cows = new int[11];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int num = Integer.parseInt(st.nextToken());
        	int place = Integer.parseInt(st.nextToken());
        	
        	if (!set.contains(num)) {
        		set.add(num);
        		cows[num] = place;
        	}
        	
        	else {
        		if (place != cows[num]) {
        			answer++;
        			cows[num] = place;
        		}
        	}
        }
        
        System.out.println(answer);
	}
}