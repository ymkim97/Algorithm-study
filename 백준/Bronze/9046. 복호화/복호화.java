import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	String input = br.readLine().replace(" ", "");
        	
        	Map<Character, Integer> map = new HashMap<>();
        	
        	for (char c : input.toCharArray()) {
        		map.put(c, map.getOrDefault(c, 0) + 1);
        	}
        	
        	List<Character> keys = new ArrayList<>(map.keySet());
        	
        	Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));
        	
        	if (keys.size() == 1) System.out.println(keys.get(0));
        	
        	else {
        		if (map.get(keys.get(0)) == map.get(keys.get(1))) System.out.println("?");
        		else System.out.println(keys.get(0));
        	}
        }
	}
}