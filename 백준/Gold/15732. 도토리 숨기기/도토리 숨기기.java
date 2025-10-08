import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<int[]> rules = new ArrayList<>(); // 0: start 1: end 2: dis

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rules.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int left = 0;
        int right = N + 1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            long cornsToPut = calculate(mid, rules);

            if (cornsToPut < D) {
                left = mid;
            } else if (cornsToPut >= D) {
                right = mid;
            }
        }

        System.out.println(right);
    }

    private static long calculate(int mid, List<int[]> rules) {
        long tmp = 0;

        for (int[] r : rules) {
            int start = r[0];
            int end = r[1];
            int dis = r[2];

            if (mid < start) continue;
            else if (mid > end) {
                tmp += (end - start) / dis + 1;
            } else {
                tmp += (mid - start) / dis + 1;
            }
        }

        return tmp;
    }
}
