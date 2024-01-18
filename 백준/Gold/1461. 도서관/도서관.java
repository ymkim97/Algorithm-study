import java.io.*;
import java.util.*;

class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int answer = 0;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num > 0) {
                positive.add(num);
                continue;
            }
            
            negative.add(num);
        }
        
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);
        
        while (!positive.isEmpty()) {
            int first = positive.remove(0);
            for (int i = 1; i < M; i++) {
                if (!positive.isEmpty()) {
                    positive.remove(0);
                }
            }
            tmp.add(first);
        }
        
        while (!negative.isEmpty()) {
            int first = negative.remove(0);
            for (int i = 1; i < M; i++) {
                if (!negative.isEmpty()) {
                    negative.remove(0);
                }
            }
            tmp.add(-first);
        }
        
        Collections.sort(tmp, Collections.reverseOrder());
        
        answer += tmp.remove(0);
        
        while (!tmp.isEmpty()) {
            answer += 2 * tmp.remove(0);
        }
        
        System.out.println(answer);
    }
}