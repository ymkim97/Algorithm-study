import java.io.*;
import java.util.*;

class Main {
    
    static String T;
    static int N, answer = Integer.MAX_VALUE;
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = br.readLine();
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int price = Integer.parseInt(st.nextToken());
            String book = st.nextToken();
            
            books.add(new Book(price, book));
        }
        
        dfs(-1, 0, new int[T.length()]);
    
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    public static void dfs(int start, int total, int[] visited) {
        int tmpCnt = 0;
        for (int i = 0; i < T.length(); i++) {
            tmpCnt += visited[i];
        }
        
        if (tmpCnt == T.length()) {
            answer = Math.min(answer, total);
            return;
        }
        
        for (int i = start + 1; i < N; i++) {
            boolean flag = false;
            Book book = books.get(i);
            int[] tmp = new int[visited.length];
            tmp = Arrays.copyOf(visited, visited.length);
            
            for (int a = 0; a < book.title.length(); a++) {
                if (T.contains(String.valueOf(book.title.charAt(a)))) {
                    for (int b = 0; b < T.length(); b++) {
                        if (tmp[b] == 0 && T.charAt(b) == book.title.charAt(a)) {
                            flag = true;
                            tmp[b] = 1;
                            break;
                        }
                    }
                }
            }
            
            if (flag) {
                dfs(i, total + book.price, tmp);
            }
        }
    }
    
    static class Book {
        int price;
        String title;
        
        public Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }
}