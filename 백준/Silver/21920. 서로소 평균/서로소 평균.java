import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        long sum = 0;
        int cnt = 0;

        for (int n : numbers) {
            if (gcd(n, X) == 1) {
                sum += n;
                cnt += 1;
            }
        }

        System.out.println((double)sum / cnt);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
