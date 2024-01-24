import java.io.*;
import java.util.*;

class Main {
    
    static int N, M, K;
    static int[][] map;
    static Set<Point> first, second;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        first = new HashSet<>();
        second = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 가로 SEARCH
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!first.isEmpty() && !second.isEmpty()) break;
                
                if (map[i][j] == 1 && checkLeft(i, j)) {
                    if (first.isEmpty()) {
                        addLeft(i, j, first);
                    }
                    
                    else {
                        addLeft(i, j, second);
                    }
                }
            }
        }
        
        // 세로 SEARCH
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!first.isEmpty() && !second.isEmpty()) break;
                
                if (map[j][i] == 1 && checkDown(j, i)) {
                    if (first.isEmpty()) {
                        addDown(j, i, first);
                    }
                    
                    else {
                        addDown(j, i, second);
                    }
                }
            }
        }
        
        if (second.isEmpty()) {
            second = new HashSet<>(first);
        }
        
        int sameCnt = 0;
        List<Point> same = new ArrayList<>();
        for (Point point : first) {
            if (second.contains(point)) {
                sameCnt += 1;
                same.add(point);
            }
        }
        
        System.out.println(sameCnt);
        
        if (sameCnt != 0) {
            Collections.sort(same, (o1, o2) -> {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                
                else {
                    return o1.x - o2.x;
                }
            });
            
            same.forEach(a -> System.out.printf("%d %d\n", a.x + 1, a.y + 1));
        }
    }
    
    public static boolean checkLeft(int x, int y) {
        int cnt = 0;
        
        for (int i = y; i < y + K; i++) {
            if (i == M) break;
            
            if (map[x][i] == 1) cnt += 1;
        }
        
        return cnt == K ? true : false;
    }
    
    public static boolean checkDown(int x, int y) {
        int cnt = 0;
        
        for (int i = x; i < x + K; i++) {
            if (i == N) break;
            
            if (map[i][y] == 1) cnt += 1;
        }
        
        return cnt == K ? true : false;
    }
    
    public static void addLeft(int x, int y, Set<Point> set) {
        for (int i = y; i < y + K; i++) {
            set.add(new Point(x, i));
        }
    }
    
    public static void addDown(int x, int y, Set<Point> set) {
        for (int i = x; i < x + K; i++) {
            set.add(new Point(i, y));
        }
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point)o;
            
            if (x == p.x && y == p.y) {
                return true;
            }
            
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}