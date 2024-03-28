import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numbers);
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int target = numbers[i];
            
            while (start < end) {
                if (start == i) {
                    start += 1;
                    continue;
                }
                
                if (end == i) {
                    end -= 1;
                    continue;
                }
                
                if (numbers[start] + numbers[end] == target) {
                    answer += 1;
                    break;
                } else if (numbers[start] + numbers[end] < target) {
                    start += 1;
                } else end -= 1;
            }
        }
        
        System.out.println(answer);
    }
}