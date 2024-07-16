import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
        	String name = br.readLine();
        	char first = name.charAt(0);
        	
        	map.put(first, map.getOrDefault(first, 0) + 1);
        }
        
        List<Character> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys);
        
        StringBuilder sb = new StringBuilder();
        
        for (char key : keys) {
        	if (map.get(key) < 5) continue;
        	
        	sb.append(key);
        }
        
        if (sb.length() == 0) System.out.println("PREDAJA");
        else System.out.println(sb.toString());
	}
}