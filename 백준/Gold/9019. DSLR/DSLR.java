import java.io.*;
import java.util.*;

class Main {
    
    static int MOD = 10_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            System.out.println(calculate(A, B));
        }
    }
    
    public static String calculate(int A, int B) {
        boolean[] visited = new boolean[10_000];
        Queue<Move> q = new LinkedList<>();
        q.offer(new Move(A));
        visited[A] = true;
        
        while (!q.isEmpty()) {
            Move now = q.poll();
            StringBuilder sb = new StringBuilder(now.calculation);
            
            if (now.number == B) {
                return now.calculation;
            }
            
            int n = now.number;
            n *= 2;
            if (n > 9999) n %= MOD;
            
            if (!visited[n]) {
                sb.append("D");
                q.offer(new Move(n, sb.toString()));
                sb.deleteCharAt(sb.length() - 1);
                visited[n] = true;
            }
            
            n = now.number;
            if (n == 0) n = 9999;
            else n -= 1;
            
            if (!visited[n]) {
                sb.append("S");
                q.offer(new Move(n, sb.toString()));
                sb.deleteCharAt(sb.length() - 1);
                visited[n] = true;
            }
            
            n = now.number;
            n = shiftLeft(n);
            
            if (!visited[n]) {
                 sb.append("L");
                q.offer(new Move(n, sb.toString()));
                sb.deleteCharAt(sb.length() - 1);
                visited[n] = true;
            }
            
            n = now.number;
            n = shiftRight(n);
            
            if (!visited[n]) {
                sb.append("R");
                q.offer(new Move(n, sb.toString()));
                sb.deleteCharAt(sb.length() - 1);
                visited[n] = true;
            }
        }
        
        return "";
    }
    
    static public int shiftLeft(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        while (sb.length() != 4) {
            sb.insert(0, '0');
        } 
        char toMove = sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(toMove);
        
        return Integer.parseInt(sb.toString());
    }
    
    static public int shiftRight(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        while (sb.length() != 4) {
            sb.insert(0, '0');
        } 
        char toMove = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.insert(0, toMove);
        
        return Integer.parseInt(sb.toString());
    }
    
    static class Move {
        int number;
        String calculation;
        
        public Move(int number) {
            this.number = number;
            calculation = "";
        }
        
        public Move(int number, String calculation) {
            this.number = number;
            this.calculation = calculation;
        }
    }
}
