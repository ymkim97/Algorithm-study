import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String content = br.readLine();
        
        int spaceBar = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int[] alphabetCount = new int[26];
        
        for (int i = 0; i < 26; i++) {
        	alphabetCount[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        char before = ' ';
        
        for (char c : content.toCharArray()) {
        	char origin = c;
        	c = Character.toLowerCase(c);
        	
        	if (c == before) continue;
        	
        	if (c == ' ') {
        		if (spaceBar == 0) {
        			System.out.println(-1);
        			return;
        		} else {
        			spaceBar -= 1;
        		}
        		
        		before = c;
        		continue;
        	}

        	if (before == ' ') {
        		sb.append(Character.toUpperCase(c));
        	}
        	
        	if (alphabetCount[c - 'a'] < 0) {
        		System.out.println(-1);
    			return;
        	}
        	
        	alphabetCount[c - 'a'] -= 1;
        	
        	before = origin;
        }
        
        for (int i = 0; i < sb.length(); i++) {
        	if (alphabetCount[Character.toLowerCase(sb.charAt(i)) - 'a'] <= 0) {
        		System.out.println(-1);
        		return;
        	}
        	
        	alphabetCount[Character.toLowerCase(sb.charAt(i)) - 'a'] -= 1;
        }
        
        System.out.println(sb.toString());
    }
}
