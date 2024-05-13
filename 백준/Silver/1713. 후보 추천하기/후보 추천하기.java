import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        Queue<Point> pq = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) return a.count - b.count;
            
            return a.firstInput - b.firstInput;
        });
        
        Map<Integer, int[]> current = new HashMap<>();
        
        for (int i = 0; i < T; i++) {
            int student = Integer.parseInt(st.nextToken());
            
            if (current.size() != N) {
                if (!current.containsKey(student)) {
                    current.put(student, new int[] {i, 1});
                    pq.offer(new Point(i, student, 1));
                }
                
                else {
                    pq.remove(new Point(i, student, 0));
                    current.put(student, new int[] {current.get(student)[0], current.get(student)[1] + 1});
                    pq.offer(new Point(current.get(student)[0], student, current.get(student)[1]));
                }
                
                continue;
            }
            
            if (current.containsKey(student)) {
                pq.remove(new Point(i, student, 0));
                current.put(student, new int[] {current.get(student)[0], current.get(student)[1] + 1});
                pq.offer(new Point(current.get(student)[0], student, current.get(student)[1]));
            }
            
            else {
                Point p = pq.poll();
                current.remove(p.number);
                current.put(student, new int[] {i, 1});
                pq.offer(new Point(i, student, 1));
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (Point p : pq) {
            answer.add(p.number);
        }
        
        Collections.sort(answer);
        
        for (int a : answer) {
            System.out.printf("%d ", a);
        }
    }
    
    static class Point {
        int firstInput;
        int number;
        int count;
        
        public Point(int firstInput, int number, int count) {
            this.firstInput = firstInput;
            this.number = number;
            this.count = count;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point)o;
            
            if (this.number == p.number) return true;
            
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}