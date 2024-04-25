import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            lst.add(s);
            maxLen = Math.max(maxLen, s.length());
        }
        
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                String s = lst.get(j);
                
                if (s.length() <= i) continue;
                
                sb.append(s.charAt(i));
            }
        }
        
        System.out.println(sb.toString());
    }
}