import java.io.*;
import java.util.*;

class Main {
    
    static int M, N;
    static List<Integer>[] switches;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        switches = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            
            switches[i] = new ArrayList<>();
            
            while(st.hasMoreTokens()) {
                switches[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        for (int i = 1; i <= N; i++) {
            Set<Integer> tmp = new HashSet<>();
            
            for (int j = 1; j <= N; j++) {
                if (j == i) continue;
                
                for (int bulb : switches[j]) {
                    tmp.add(bulb);
                    if (tmp.size() == M) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(0);
    }
}