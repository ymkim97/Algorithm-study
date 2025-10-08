import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(solve(br)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static String solve(BufferedReader br) throws Exception{
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());

        List<Node> map = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.add(new Node(x, y));
        }

        st = new StringTokenizer(br.readLine());
        int fesX = Integer.parseInt(st.nextToken());
        int fesY = Integer.parseInt(st.nextToken());

        map.add(new Node(fesX, fesY));

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {curX, curY});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            map.remove(new Node(x, y));

            if (x == fesX && y == fesY) {
                return "happy";
            }

            for (Node next : map) {
                if (Math.abs(x - next.x) + Math.abs(y - next.y) <= 1000) {
                    q.offer(new int[] {next.x, next.y});
                }
            }
        }
        
        return "sad";
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Node n = (Node)o;

            if (this.x == n.x && this.y == n.y) return true;

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
