import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        int[][] cnt = new int[4][4];
        
        Point f = new Point(1);
        Point s = new Point(2);
        Point t = new Point(3);
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
 
        	cnt[1][a] += 1;
        	cnt[2][b] += 1;
        	cnt[3][c] += 1;
        }
        
        f.oneCount = cnt[1][1];
        f.twoCount = cnt[1][2];
        f.threeCount = cnt[1][3];
        
        s.oneCount = cnt[2][1];
        s.twoCount = cnt[2][2];
        s.threeCount = cnt[2][3];
        
        t.oneCount = cnt[3][1];
        t.twoCount = cnt[3][2];
        t.threeCount = cnt[3][3];
        
        f.score = f.oneCount + (2 * f.twoCount) + (3 * f.threeCount);
        s.score = s.oneCount + (2 * s.twoCount) + (3 * s.threeCount);
        t.score = t.oneCount + (2 * t.twoCount) + (3 * t.threeCount);
        
        List<Point> lst = new ArrayList<>();
        
        lst.add(f);
        lst.add(s);
        lst.add(t);
        
        Collections.sort(lst, (a, b) -> {
        	if (a.score == b.score) {
        		if (a.threeCount == b.threeCount) {
        			return b.twoCount - a.twoCount;
        		}
        		return b.threeCount - a.threeCount;
        	}
        	
        	return b.score - a.score;
        });
        
        if (lst.get(0).threeCount == lst.get(1).threeCount && lst.get(0).twoCount == lst.get(1).twoCount) {
        	System.out.printf("0 %d", lst.get(0).score);
        } else {
        	System.out.printf("%d %d", lst.get(0).number, lst.get(0).score);
        }
        
}
	
	static class Point {
		int number;
		int score;
		int oneCount;
		int twoCount;
		int threeCount;
		
		public Point(int n) {
			this.number = n;
		}
	}
}