import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	cows[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] changes = new int[Q];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < Q; i++) {
        	changes[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
        	sum += cows[i] * cows[(i + 1) % N] * cows[(i + 2) % N] * cows[(i + 3) % N];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < Q; i++) {
        	int changeIdx = changes[i] - 1;
        	
        	for (int j = 0; j < 4; j++) {
        		int curIdx = (changeIdx - j + N) % N;
        		int tmpSumBefore = cows[curIdx] * cows[(curIdx + 1) % N] * cows[(curIdx + 2) % N] * cows[(curIdx + 3) % N];
        		int tmpSumAfter = tmpSumBefore * -1;
        		
        		sum += (tmpSumAfter - tmpSumBefore);
        	}
        	
        	cows[changeIdx] = -1 * cows[changeIdx];
        	
        	sb.append(sum).append("\n");
        }  
        
        System.out.println(sb.toString());
    }
}
