import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int n = Integer.parseInt(st.nextToken());
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
        	int n = Integer.parseInt(st.nextToken());
        	
        	sb.append(map.getOrDefault(n, 0)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
