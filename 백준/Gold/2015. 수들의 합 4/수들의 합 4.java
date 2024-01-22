import java.io.*;
import java.util.*;

class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < N + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            
            if (arr[i] == K) {
                answer += 1;
            }
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (map.containsKey(arr[i] - K)) {
                answer += map.get(arr[i] - K);
            }
            
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            
            else {
                map.put(arr[i], 1L);
            }
        }
        
        System.out.println(answer);
    }
}