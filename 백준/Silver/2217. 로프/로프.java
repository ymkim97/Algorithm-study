import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] ropes = new Integer[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, ropes[i] * (N - i));
        }

        System.out.println(max);
    }
}