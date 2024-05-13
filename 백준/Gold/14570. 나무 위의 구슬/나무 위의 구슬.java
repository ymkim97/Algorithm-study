import java.io.*;
import java.util.*;

class Main {
    
    static int answer = 0;
    static List<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());
            
            tree[i].add(leftChild);
            tree[i].add(rightChild);
        }
        
        long K = Long.parseLong(br.readLine());
        
        dfs(1, K);
        
        System.out.println(answer);
    }
    
    public static void dfs(int cur, long k) {
        List<Integer> now = tree[cur];
        int left = now.get(0);
        int right = now.get(1);
        
        if (left == -1 && right == -1) {
            answer = cur;
            return;
        }
        
        else if (left != -1 && right != -1) {
            if (k % 2 == 1) dfs(left, k / 2 + 1);
            else dfs(right, k / 2);
        }
        
        else if (left == -1) {
            dfs(right, k);
        }
        
        else dfs(left, k);
    }
}