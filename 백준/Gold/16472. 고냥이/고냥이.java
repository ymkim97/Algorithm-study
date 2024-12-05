import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        String s = br.readLine();
        
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        
        int answer = 0;
        
        for (char c : s.toCharArray()) {
        	if (set.size() == N) {
        		boolean isOver = true;
        		
        		for (char val : set) {
        			if (val == c) isOver = false;
        		}
        		
        		if (isOver) {
        			while (set.size() != N - 1) {
        				char re = q.poll();
        				
        				map.put(re, map.get(re) - 1);
        				
        				if (map.get(re) == 0) set.remove(re);
        			}
        		}
        	}
        	
    		set.add(c);
    		q.offer(c);
    		map.put(c, map.getOrDefault(c, 0) + 1);
    		
        	answer = Math.max(answer, q.size());
        }
        
        System.out.println(answer);
	}
}
