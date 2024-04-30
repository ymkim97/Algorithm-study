import java.io.*;
import java.util.*;

class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int test = 0; test < m; test++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a == b) {
                if (cmd == 1) {
                    sb.append("YES\n");
                }
                continue;
            }
            
            int parentA = find(a);
            int parentB = find(b);
            
            if (cmd == 0 && parentA != parentB) {
                union(parentA, parentB);
            }
            
            else if (cmd == 1) {
                if (parentA == parentB) sb.append("YES\n");
                
                else sb.append("NO\n");
            }
        }
        
        System.out.println(sb.toString());
    }
    
    public static int find(int num) {
        if (parent[num] == num) return num;
        
        return parent[num] = find(parent[num]);
    }
    
    public static void union(int a, int b) {
        parent[a] = b;
    }
}