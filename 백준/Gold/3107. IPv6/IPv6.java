import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String compressed = br.readLine();
        
        String[] splited = compressed.split(":");
        
        ArrayList<String> origin = new ArrayList<>();
        
        int firstZeroIdx = -1;
        
        for (int i = 0; i < splited.length; i++) {
        	String s = splited[i];
        	
        	if (s.isEmpty()) {
        		if (firstZeroIdx == -1) firstZeroIdx = i;
        	}
        	else {
        		if (s.length() == 4) origin.add(s);
        		else {
        			while (s.length() != 4) {
        				s = "0" + s;
        			}
        			if (origin.size() == 8) origin.remove(0);
        			origin.add(s);
        		}
        	}
        }
        
        if (firstZeroIdx == -1) firstZeroIdx = origin.size();
        
        while (origin.size() < 8) {
        	origin.add(firstZeroIdx, "0000");
        	firstZeroIdx += 1;        	
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < origin.size(); i++) {
        	if (i != origin.size() - 1) sb.append(origin.get(i)).append(":");
        	else sb.append(origin.get(i));
        }
        
        System.out.println(sb.toString());
	}
}