import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] lines = new String[r];

        for (int i = 0; i < r; i++) {
            lines[i] = br.readLine();
        }

        int start = 0;
        int end = r - 1;

        if (end == 1) {
            System.out.println(check(1, lines) ? 1 : 0);
            return;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (check(mid, lines)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (start == r - 2) {
            System.out.println(check(r - 1, lines) ? r - 1 : r - 2);
            return;
        }

        System.out.println(start);
    }

    private static boolean check(int mid, String[] lines) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < lines[0].length(); i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = mid; j < lines.length; j++) {
                sb.append(lines[j].charAt(i));
            }

            if (set.contains(sb.toString())) return false;

            set.add(sb.toString());
        }

        return true;
    }
}