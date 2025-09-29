import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> lst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            int delivery = Integer.parseInt(st.nextToken());

            lst.add(new int[] {cost, delivery});
            set.add(cost);
        }

        int answer = 0;
        
        long maxProfit = 0;

        for (int c : set) {
            long tmpProfit = 0;

            for (int[] each : lst) {
                if (each[0] >= c && c > each[1]) {
                    tmpProfit += (c - each[1]);
                }
            }

            if (tmpProfit == maxProfit) {
                answer = Math.min(answer, c);
            } else if (tmpProfit > maxProfit) {
                answer = c;
                maxProfit = tmpProfit;
            }
        }

        System.out.println(answer);
    }
}
