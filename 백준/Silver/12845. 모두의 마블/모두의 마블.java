import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        int idx = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i != idx) {
                sum += max + arr[i];
            }
        }

        System.out.println(sum);
    }
}