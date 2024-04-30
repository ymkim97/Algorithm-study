import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N + 1][6];
        
        int maxStudent = 0;
        int minGrade = 0;
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            table[i][a] = table[i - 1][a] + 1;
            table[i][b] = table[i - 1][b] + 1;
            
      
            if ((table[i][a] == maxStudent && a < minGrade) || (table[i][a] > maxStudent)) {
                maxStudent = table[i][a];
                minGrade = a;
            }
            
            if ((table[i][b] == maxStudent && b < minGrade) || (table[i][b] > maxStudent)) {
                maxStudent = table[i][b];
                minGrade = b;
            }
        }
        
        System.out.printf("%d %d", maxStudent, minGrade);
    }
}