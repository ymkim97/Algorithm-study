import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        
        while (true) {
        	String s = br.readLine();
        	
        	if (s == null) break;
        	
        	map.put(s, map.getOrDefault(s, 0) + 1);
        	count += 1;
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys);
        
        StringBuilder sb = new StringBuilder();
        
        for (String key : keys) {
        	sb.append(key).append(" ");
        	sb.append(String.format("%.4f", (double)map.get(key) * 100 / count)).append("\n");
        }
        
        System.out.println(sb);
	}
}