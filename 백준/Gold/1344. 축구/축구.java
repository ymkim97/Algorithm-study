import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int UNIT = 18;

        double A = Double.parseDouble(br.readLine()) / 100;
        double B = Double.parseDouble(br.readLine()) / 100;
        
        double[][][] dp = new double[UNIT + 1][UNIT + 1][UNIT + 1];
        dp[0][0][0] = 1.0;
        
        for (int i = 1; i <= UNIT; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (j > 0) dp[i][j][k] += dp[i - 1][j - 1][k] * A * (1 - B);
                    if (k > 0) dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - A) * B;
                    if (j > 0 && k > 0) dp[i][j][k] += dp[i - 1][j - 1][k - 1] * A * B;
                    
                    dp[i][j][k] += dp[i - 1][j][k] * (1 - A) * (1 - B);
                }
            }
        }
        
        double res = 0;
        for (int i = 0; i <= UNIT; i++) {
            for (int j = 0; j <= UNIT; j++) {
                if (isPrimeNum(i) || isPrimeNum(j)) res += dp[UNIT][i][j];
            }
        }
        
        System.out.printf("%.7f", res);
    }
    
    public static boolean isPrimeNum(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}