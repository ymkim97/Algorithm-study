import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (true) {
            count += 1;

            int tmp = belt[2 * N - 1];

            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i] -= 1;
                    robot[N - 1] = false;
                }
            }

            if (belt[0] > 0) {
                robot[0] = true;
                belt[0] -= 1;
            }

            int zeros = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (belt[i] == 0) zeros += 1;
            }

            if (zeros >= K) break;
        }

        System.out.println(count);
    }
}