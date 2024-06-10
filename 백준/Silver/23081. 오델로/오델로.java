import java.util.*;
import java.io.*;

class Main {
	
	static int[] mx = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] my = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        ArrayList<int[]> answers = new ArrayList<>(); //0: y, 1: x, 2: cnt
        
        int N = Integer.parseInt(br.readLine());
        
        char[][] map = new char[N][N];
        
        for (int i = 0; i < N; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if (map[i][j] == '.') search(i, j, map, answers, N);
        	}
        }
        
        Collections.sort(answers, (a, b) -> {
        	if (a[2] == b[2]) {
        		if (a[0] == b[0]) return a[1] - b[1];
        		
        		return a[0] - b[0];
        	}
        	
        	return b[2] - a[2];
        });
        
        if (answers.isEmpty()) System.out.println("PASS");
        else System.out.printf("%d %d\n%d\n", answers.get(0)[1], answers.get(0)[0], answers.get(0)[2]);
	}
	
	public static void search(int y, int x, char[][] map, ArrayList<int[]> answers, int N) {
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			int dx = mx[i] + x;
			int dy = my[i] + y;
			
			if (dx < 0 || dy < 0 || dx >= N || dy >= N || map[dy][dx] != 'W') continue;
			
			int tmp = 0;
			boolean flag = false;
			
			while (dx >= 0 && dx < N && dy >= 0 && dy < N) {
				if (map[dy][dx] == 'B') {
					flag = true;
					break;
				}
				
				if (map[dy][dx] == '.') break;
				
				tmp += 1;
				dx += mx[i];
				dy += my[i];
			}
			
			if (flag) cnt += tmp;
		}
		
		if (cnt > 0) answers.add(new int[] {y, x, cnt});
	}
}