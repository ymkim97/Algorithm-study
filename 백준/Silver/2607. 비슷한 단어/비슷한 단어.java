import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        String word = "";

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Map<Character, Integer> copyMap = new HashMap<>(map);

            if (i == 0) {
                word = input;
                for (char c : input.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }

                continue;
            }

            int diff = 0;
            int lengthDiff = input.length() - word.length();
            for (char c : input.toCharArray()) {
                if (!copyMap.containsKey(c) || copyMap.get(c) == 0) {
                    diff += 1;
                }

                else if (copyMap.get(c) > 0) {
                    copyMap.put(c, copyMap.get(c) - 1);
                }
            }

            if ((diff == 0 && lengthDiff == 1) || (diff == 1 && lengthDiff == 0) || (diff == 1 && lengthDiff == 1) ||
                (diff == 0 && lengthDiff == -1) || (diff == 0 && lengthDiff == 0)) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}