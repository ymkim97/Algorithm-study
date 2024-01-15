import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static char[][] candy;

    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mi = {1, -1, 0, 0};
        int[] mj = {0, 0, 1, -1};

        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            candy[i] = br.readLine().toCharArray();
        }

        answer = Math.max(answer, calculate());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int di = i + mi[k];
                    int dj = j + mj[k];

                    if (di < 0 || dj < 0 || di >= N || dj >= N || candy[di][dj] == candy[i][j]) continue;

                    char tmp = candy[i][j];
                    candy[i][j] = candy[di][dj];
                    candy[di][dj] = tmp;

                    answer = Math.max(answer, calculate());

                    tmp = candy[i][j];
                    candy[i][j] = candy[di][dj];
                    candy[di][dj] = tmp;
                }
            }
        }

        System.out.println(answer);
    }

    public static int calculate() {
        int max = 0;

        // 가로로 최대 연속 구하기
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            char prev = ' ';

            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    tmp += 1;
                    prev = candy[i][j];
                    continue;
                }

                if (prev == candy[i][j]) {
                    tmp += 1;
                }

                else {
                    prev = candy[i][j];
                    max = Math.max(max, tmp);
                    tmp = 1;
                }
            }

            max = Math.max(max, tmp);
        }

        // 세로로 최대 연속 구하기
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            char prev = ' ';

            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    tmp += 1;
                    prev = candy[j][i];
                    continue;
                }

                if (prev == candy[j][i]) {
                    tmp += 1;
                }

                else {
                    prev = candy[j][i];
                    max = Math.max(max, tmp);
                    tmp = 1;
                }
            }

            max = Math.max(max, tmp);
        }

        return max;
    }
}