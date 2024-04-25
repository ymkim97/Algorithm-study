import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        long[] acid = new long[N];
        List<Long> answer = new ArrayList<>();
        
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            acid[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(acid);
        long minAbs = Long.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int fixIdx = i;
            
            int left = 0;
            int right = N - 1;
            
            while (left < right) {
                if (left == fixIdx || right == fixIdx) {
                    if (left == fixIdx) left += 1;
                    else right -= 1;
                    continue;
                }
                
                long sum = acid[fixIdx] + acid[left] + acid[right];
                
                if (Math.abs(sum) < minAbs) {
                    minAbs = Math.abs(sum);
                    answer = new ArrayList<>();
                    answer.add(acid[fixIdx]);
                    answer.add(acid[left]);
                    answer.add(acid[right]);
                }
                
                if (sum > 0) {
                    right -= 1;
                } else if (sum < 0){
                    left += 1;
                } else {
                    break;
                }
            }
        }
        
        Collections.sort(answer);
        System.out.printf("%d %d %d", answer.get(0), answer.get(1), answer.get(2));
    }
}