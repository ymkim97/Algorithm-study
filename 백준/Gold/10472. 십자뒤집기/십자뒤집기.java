import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringBuilder targetSb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                String line = br.readLine();
                for (int j = 0; j < 3; j++) {
                    char c = line.charAt(j);
                    targetSb.append(c == '*' ? '1' : '0');
                }
            }
            String target = targetSb.toString();
            int ans = bfsMinClicks("000000000", target);
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }

    private static int bfsMinClicks(String start, String target) {
        if (start.equals(target)) return 0;

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int curDist = dist.get(cur);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char[] nextArr = cur.toCharArray();

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;

                        int idx = nx * 3 + ny;
                        nextArr[idx] = flip(nextArr[idx]);
                    }

                    int centerIdx = i * 3 + j;
                    nextArr[centerIdx] = flip(nextArr[centerIdx]);

                    String next = new String(nextArr);
                    if (dist.containsKey(next)) continue;
                    dist.put(next, curDist + 1);
                    if (next.equals(target)) return curDist + 1;
                    q.add(next);
                }
            }
        }

        return -1;
    }

    private static char flip(char c) {
        return c == '0' ? '1' : '0';
    }
}
