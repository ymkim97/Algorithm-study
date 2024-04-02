import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int target = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[2 * m + 1];
        int[] B = new int[2 * n + 1];
        
        for (int i = 1; i <= m; i++) {
            A[i] = A[i + m] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= n; i++) {
            B[i] = B[i + n] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= 2 * m; i++) A[i] += A[i - 1];
        for (int i = 1; i <= 2 * n; i++) B[i] += B[i - 1];
        
        int answer = 0;
        
        Map<Integer, Integer> cnt = new HashMap<>();
        if (A[m] == target) answer += 1;
        cnt.put(A[m], 1);
        
        for (int i = 1; i <= m; i++) {
            for (int j = i; j < i + m - 1; j++) {
                int rangeSum = A[j] - A[i - 1];
                if (rangeSum == target) answer += 1;
                if (rangeSum >= target) continue;
                
                cnt.put(rangeSum, cnt.getOrDefault(rangeSum, 0) + 1);
            }
        }
        
        if (B[n] == target) answer += 1;
        answer += cnt.getOrDefault(target - B[n], 0);
        
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < i + n - 1; j++) {
                int rangeSum = B[j] - B[i - 1];
                if (rangeSum == target) answer += 1;
                
                answer += cnt.getOrDefault(target - rangeSum, 0);
            }
        }
        
        System.out.println(answer);
    }
}