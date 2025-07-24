import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> mapA = new HashSet<>();
        for (int i = 0; i < a; i++) {
            mapA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Set<Integer> mapB = new HashSet<>();
        for (int i = 0; i < b; i++) {
            mapB.add(Integer.parseInt(st.nextToken()));
        }

        int first = 0;
        for (int n : mapA) {
            if (!mapB.contains(n)) first += 1;
        }

        int second = 0;
        for (int n : mapB) {
            if (!mapA.contains(n)) second += 1;
        }

        System.out.println(first + second);
    }
}