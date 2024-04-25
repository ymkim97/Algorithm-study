import java.io.*;
import java.util.*;

class Main {

    static int answer = Integer.MAX_VALUE;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        if (isSorted(nums)) {
            System.out.println(0);
            return;
        }
        
        bfs(nums);
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    static public void bfs(int[] nums) {
        Set<String> visited = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(nums, 0));
        visited.add(Arrays.toString(nums));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            if(isSorted(p.nums)) {
                answer = p.count;
                return;
            }
            
            for (int i = 0; i <= N - K; i++) {
                int[] copy = Arrays.copyOf(p.nums, p.nums.length);
                int idx = i + K - 1;
                
                for (int j = i; j < i + K / 2; j++) {
                    int tmp = copy[j];
                    copy[j] = copy[idx];
                    copy[idx] = tmp;
                    idx -= 1;
                }
                
                String s = Arrays.toString(copy);
                
                if (!visited.contains(s)) {
                    visited.add(s);
                    q.offer(new Point(copy, p.count + 1));
                }
            }
        }
        
    }
    
    static public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        
        return true;
    }
    
    static class Point {
        int[] nums;
        int count;
        
        public Point(int[] nums, int count) {
            this.nums = nums;
            this.count = count;
        }
    }
}