import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // node
        int M = Integer.parseInt(st.nextToken()); // edge
        int A = Integer.parseInt(st.nextToken()); // start
        int B = Integer.parseInt(st.nextToken()); // end
        int C = Integer.parseInt(st.nextToken()); // money

        List<Node>[] map = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        int left = 1;
        int right = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            right = Math.max(right, w);

            map[a].add(new Node(b, w));
            map[b].add(new Node(a, w));
        }
        
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstra(A, B, C, mid, map)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer == 0 ? -1 : answer);
    }

    private static boolean dijkstra(int start, int end, int money, int maxCost, List<Node>[] map) {
        int[] distance = new int[map.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.number] < node.weight) continue;

            for (Node next : map[node.number]) {
                if (distance[next.number] > next.weight + distance[node.number] && next.weight <= maxCost) {
                    distance[next.number] = next.weight + distance[node.number];
                    pq.offer(new Node(next.number, distance[next.number]));
                }
            }
        }

        return distance[end] <= money ? true : false;
    }

    static class Node {
        int number;
        int weight;

        public Node(int n, int w) {
            this.number = n;
            this.weight = w;
        }
    }
}
