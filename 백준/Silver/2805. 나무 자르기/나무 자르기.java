import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int left = 0;
        int right = maxHeight;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long avail = check(trees, mid);

            if (avail >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static long check(int[] trees, int mid) {
        long total = 0;

        for (int tree : trees) {
            total += tree - mid >= 0 ? tree - mid : 0;
        }

        return total;
    }
}