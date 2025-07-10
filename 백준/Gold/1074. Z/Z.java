import java.util.*;
import java.io.*;

class Main {
	
	static int visitCount = 0;
	static int c, r;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        dfs(0, 0, (int)Math.pow(2, N));
	}
	
	private static void dfs(int x, int y, int size) {	
		if (size == 1) {
			System.out.println(visitCount);
			
			return;
		}
		
		int newSize = size / 2;
		
		if (r < x + newSize && c < y + newSize) {
			dfs(x, y, newSize);
		} else if (r < x + newSize && c >= y + newSize) {
			visitCount += (size * size) / 4;
			dfs(x, y + newSize, newSize);
		} else if (r >= x + newSize && c < y + newSize) {
			visitCount += (size * size) / 4 * 2;
			dfs(x + newSize, y, newSize);
		} else if (r >= x + newSize && c >= y + newSize) {
			visitCount += (size * size) / 4 * 3;
			dfs(x + newSize, y + newSize, newSize);
		}
	}
}
