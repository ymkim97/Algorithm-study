import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<House> houses = new ArrayList<>();
        long totalPeople = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            houses.add(new House(n, p));
            totalPeople += p;
        }
        
        Collections.sort(houses, (a, b) -> {
            return a.n - b.n;
        });
        
        long tmp = 0;
        
        for (int i = 0; i < N; i++) {
            tmp += houses.get(i).p;
            
            if ((totalPeople + 1) / 2 <= tmp) {
                System.out.println(houses.get(i).n);
                break;
            }
        }
    }
    
    static class House {
        int n;
        int p;
        
        public House (int n, int p) {
            this.n = n;
            this.p = p;
        }
    }
}