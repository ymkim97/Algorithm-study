import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length -1;

        long minAbs = Long.MAX_VALUE;
        int a = 0;
        int b = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < minAbs) {
                a = arr[left];
                b = arr[right];
                minAbs = Math.abs(sum);
            }

            if (sum > 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        System.out.printf("%d %d", a, b);
    }
}