import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int tmp = 0;
        for (int i = 1; i <= K; i++) tmp += i;
        
        if (tmp > N) {
        	System.out.println(-1);
        	return;
        }
        
        N -= tmp;
        int answer = K - 1;
        
        if (N % K != 0) answer += 1;
        
        System.out.println(answer);
	}
}