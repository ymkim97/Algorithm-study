import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String input = br.readLine();

        if (input.length() % 4 != 0) {
            System.out.println(0);
            return;
        }

        int idx = 0;
    
        while (idx < input.length()) {
            int lastIdx = idx;

            while (lastIdx < input.length() && input.charAt(lastIdx) == 'w') {
                lastIdx += 1;
            }

            if (lastIdx == input.length() || input.charAt(idx) != 'w') {
                System.out.println(0);
                return;
            }

            lastIdx -= 1;

            int n = lastIdx - idx + 1;

            if (!check(n, idx, input)) {
                System.out.println(0);
                return;
            }

            idx += n * 4;
        }
        
        System.out.println(1);
    }

    private static boolean check(int n, int startIdx, String input) {
        if (startIdx + n * 4 > input.length()) return false;

        StringBuilder target = new StringBuilder();

        for (int i = 0; i < n; i++) {
            target.append('w');
        }

        for (int i = 0; i < n; i++) {
            target.append('o');
        }

        for (int i = 0; i < n; i++) {
            target.append('l');
        }

        for (int i = 0; i < n; i++) {
            target.append('f');
        }

        return target.toString().equals(input.substring(startIdx, startIdx + n * 4));
    }
}
