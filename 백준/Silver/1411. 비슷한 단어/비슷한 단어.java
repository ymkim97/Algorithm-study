import java.util.*;
import java.io.*;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] letters = new String[N];
        
        for (int i = 0; i < N; i++) {
        	letters[i] = br.readLine();
        }
        
        for (int i = 0; i < N; i++) {
        	String s = letters[i];
        	
        	for (int j = i + 1; j < N; j++) {
        		String toComp = letters[j];
        		
        		Map<Character, Character> map = new HashMap<>();
        		Set<Character> set = new HashSet<>();
        		boolean flag = true;
        		
        		for (int m = 0; m < s.length(); m++) {
        			char c = map.getOrDefault(s.charAt(m), 'X');
        			
        			if (c == 'X') {
        				if (set.contains(toComp.charAt(m))) {
        					flag = false;
        					break;
        				}
        				map.put(s.charAt(m), toComp.charAt(m));
        				set.add(toComp.charAt(m));
        			}
        			
        			else if (c != toComp.charAt(m)) {
        				flag = false;
        				break;
        			}
        		}
        	
        		if (flag) {
        			answer += 1;
        		}
        	}
        }
        
        System.out.println(answer);
	}
}