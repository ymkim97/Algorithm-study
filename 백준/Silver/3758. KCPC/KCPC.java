import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] log = new int[n + 1][4];
            Map<Integer, Integer>[] solvedPerTeam = new Map[n + 1];
            for (int tmp = 0; tmp < n + 1; tmp++) {
                solvedPerTeam[tmp] = new HashMap<>();
            }

            for (int each = 0; each < m; each++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if (!solvedPerTeam[i].containsKey(j)) { // 문제를 푼 기록이 없다면
                    solvedPerTeam[i].put(j, s);
                    log[i][0] = i;
                    log[i][1] += s;
                    log[i][2] += 1;
                    log[i][3] = each;
                }

                else {
                    if (solvedPerTeam[i].get(j) >= s) { // 기존에 플었던 문제의 점수가 더 높거나 같으면
                        log[i][2] += 1;
                        log[i][3] = each;
                    }

                    else {
                        int lastScore = solvedPerTeam[i].get(j);
                        solvedPerTeam[i].put(j, s);

                        log[i][1] += (s - lastScore);
                        log[i][2] += 1;
                        log[i][3] = each;
                    }
                }
            }

            Arrays.sort(log, (o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }

                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }

                return o1[3] - o2[3];
            });

            for (int a = 0 ; a < n + 1; a++) {
                if (log[a][0] == t) {
                    System.out.println(a + 1);
                    break;
                }
            }
        }
    }
}