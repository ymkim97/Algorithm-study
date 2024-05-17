import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();
        Set<Character> keys = new HashSet<>();
        
        for (int test = 0; test < N; test++) {
        	String cmd = br.readLine();
        	
        	String[] split = cmd.split(" ");
        	boolean flag = false;
        	
        	for (int idx = 0; idx < split.length; idx++) {
        		char start = split[idx].charAt(0);
        		if (!keys.contains(Character.toUpperCase(start))) {
        			keys.add(Character.toUpperCase(start));
        			flag = true;
        			split[idx] = '[' + String.valueOf(start) + ']' + split[idx].substring(1);
        			break;
        		}
        	}
        	
        	if (flag) {
        		StringBuilder sb = new StringBuilder();
        		for (int idx = 0; idx < split.length; idx++) {
        			sb.append(split[idx]);
        			if (idx != split.length - 1) sb.append(" ");
        		}
        		
        		answer.add(sb.toString());
        		continue;
        	}
        	
        	for (int i = 0; i < cmd.length(); i++) {;
        		char c = cmd.charAt(i);
        		
        		if (c == ' ') continue;
        		
        		if (!keys.contains(Character.toUpperCase(c))) {
        			keys.add(Character.toUpperCase(c));
        			answer.add(cmd.substring(0, i) + '[' + c + ']' + cmd.substring(i + 1));
        			flag = true;
        			break;
        		}
        	}
        	
        	if (!flag) answer.add(cmd);
        }
        
        for (String s : answer) {
        	System.out.println(s);
        }
    }
}