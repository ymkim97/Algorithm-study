import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> l = new ArrayList<>();
    static String result;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());

            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }

            l.add(tmp);
        }

        result = "-1";
        visited = new boolean[N][10];
        boolean flag = false;

        for (int i = 0; i < l.get(0).size(); i++) {
            visited[0][l.get(0).get(i)] = true;

            if (dfs(l.get(0).get(i), 1)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int i = result.length() - 1; i >= 0; i--) {
                System.out.println(result.charAt(i));
            }
        } else {
            System.out.println(result);
        }
    }

    private static boolean dfs(int prev, int day) {
        if (day == N) {
            result = String.valueOf(prev);
            return true;
        }

        for (int i = 0; i < l.get(day).size(); i++) {
            if (l.get(day).get(i) == prev || visited[day][l.get(day).get(i)]) continue;

            visited[day][l.get(day).get(i)] = true;

            if (dfs(l.get(day).get(i), day + 1)) {
                result += String.valueOf(prev);
                return true;
            }
        }

        return false;
    }
}
