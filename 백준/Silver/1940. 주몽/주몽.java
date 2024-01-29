import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] ingredient = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ingredient);
        
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            if (ingredient[left] + ingredient[right] == M) {
                answer += 1;
                left += 1;
                right -= 1;
            }
            
            else if (ingredient[left] + ingredient[right] < M) {
                left += 1;
            }
            
            else {
                right -= 1;
            }
        }
        
        System.out.println(answer);
    }
}