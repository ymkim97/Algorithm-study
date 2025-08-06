import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int truthPeopleCount = Integer.parseInt(st.nextToken());
        Set<Integer> truth = new HashSet<>();

        for (int i = 0; i < truthPeopleCount; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int[] parent = new int[N + 1];
        ArrayList<Integer>[] parties = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            ArrayList<Integer> party = parties[i];
            st = new StringTokenizer(br.readLine());

            int peopleCount = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            party.add(x);

            for (int j = 1; j < peopleCount; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y, parent, truth);
                party.add(y);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean hasTruth = false;

            for (int n : parties[i]) {
                if (truth.contains(find(n, parent))) {
                    hasTruth = true;
                    break;
                }
            }

            if (!hasTruth) answer += 1;
        }

        System.out.println(answer);
    }

    private static void union(int x, int y, int[] parent, Set<Integer> truth) {
        x = find(x, parent);
        y = find(y, parent);

        if (truth.contains(y)) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    private static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x], parent);
    }
}