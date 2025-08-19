import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] fluids = new int[N];

        for (int i = 0 ; i < N; i++) {
            fluids[i] = Integer.parseInt(st.nextToken());
        }

        if (fluids[N - 1] < 0) {
            System.out.println(fluids[N - 1] + fluids[N - 2]);
            return;
        } else if (fluids[0] >= 0){
            System.out.println(fluids[0] + fluids[1]);
            return;
        }

        int left = 0;
        int right = N - 1;

        int answer = Integer.MAX_VALUE;

        while (left != right) {
            int sum = fluids[left] + fluids[right];

            if (Math.abs(sum) < Math.abs(answer)) {
                answer = sum;
            }

            if (sum > 0) {
                right -= 1;
            } else if (sum < 0) {
                left += 1;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}