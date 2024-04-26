import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            people[i] = num;
            set.add(num);
        }
        
        int answer = 1;
        
        for (int n : set) {
            
            int prev = -1;
            int count = 1;
            
            for (int i = 0; i < N; i++) {
                if (people[i] == n) continue;
                
                if (prev == people[i]) {
                    count += 1;
                    answer = Math.max(answer, count);
                }
                
                else {
                    prev = people[i];
                    count = 1;
                }
            }
            
            
        }
        
        System.out.println(answer);
    }
}