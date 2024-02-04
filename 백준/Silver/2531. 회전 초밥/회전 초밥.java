import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        int left = 0;
        int right = k - 1;
        
        for (int i = left; i <= right; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }
        
        int answer = map.size();
        
        while (left < sushi.length) {
            left += 1;
            right = (right + 1) % sushi.length;
            
            if (left > sushi.length) break;
            
            map.put(sushi[left - 1], map.get(sushi[left - 1]) - 1);
            if (map.get(sushi[left - 1]) == 0) map.remove(sushi[left - 1]);
            
            map.put(sushi[right], map.getOrDefault(sushi[right], 0) + 1);
            
            if (!map.containsKey(c)) {
                answer = Math.max(answer, map.size() + 1);
            }
            
            else {
                answer = Math.max(answer, map.size());
            }
            
        }
     
        System.out.println(answer);   
    }
}