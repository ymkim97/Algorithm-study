import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	int n = Integer.parseInt(br.readLine());
        	int answer = 1;
        	
        	Map<String, Integer> map = new HashMap<>();
        	
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		String name = st.nextToken();
        		String type = st.nextToken();
        		
        		map.put(type, map.getOrDefault(type, 0) + 1);
        	}
        	
        	List<String> keys = new ArrayList<>(map.keySet());
        	
        	for (String key : keys) {
        		int cnt = map.get(key);
        		
        		answer *= (cnt + 1);
        	}
        	
        	answer -= 1;
        	
        	System.out.println(answer);
        }
	}
}