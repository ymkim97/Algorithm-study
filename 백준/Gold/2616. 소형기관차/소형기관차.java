import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
     
        st = new StringTokenizer(br.readLine());
        int[] trains = new int[N];
        
        for (int i = 0; i < N; i++) {
        	trains[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxPassengerPerTrain = Integer.parseInt(br.readLine());
        
        int[] trainSum = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	trainSum[i] = trainSum[i - 1] + trains[i - 1];
        }
        
        int[][] dp = new int[4][N + 1];
        
        for (int i = 1; i <= 3; i++) {
        	for (int j = i * maxPassengerPerTrain; j <= N; j++) {
        		dp[i][j] = Math.max(dp[i][j - 1], trainSum[j] - trainSum[j - maxPassengerPerTrain] + dp[i - 1][j - maxPassengerPerTrain]);
        	}
        }
        
        System.out.println(dp[3][N]);
    }
}
