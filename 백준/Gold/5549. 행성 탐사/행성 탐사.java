import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());
        
        int[][] jungle = new int[M + 1][N + 1];
        int[][] ocean = new int[M + 1][N + 1];
        int[][] ice = new int[M + 1][N + 1];
        
        for (int i = 1; i <= M; i++) {
        	String input = br.readLine();
        	
        	for (int j = 1; j <= N; j++) {
        		char c = input.charAt(j - 1);
        		
        		if (c == 'J') jungle[i][j] = 1;
        		else if (c == 'O') ocean[i][j] = 1;
        		else ice[i][j] = 1;
        	}
        }
        
        for (int i = 1; i <= M; i++) {
        	for (int j = 1; j <= N; j++) {
        		jungle[i][j] += jungle[i][j - 1] + jungle[i - 1][j] - jungle[i - 1][j - 1];
        		ocean[i][j] += ocean[i][j - 1] + ocean[i - 1][j] - ocean[i - 1][j - 1];
        		ice[i][j] += ice[i][j - 1] + ice[i - 1][j] - ice[i - 1][j - 1];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	int jCount = jungle[x2][y2] - jungle[x1 - 1][y2] - jungle[x2][y1 - 1] + jungle[x1 - 1][y1 - 1];
        	int oCount = ocean[x2][y2] - ocean[x1 - 1][y2] - ocean[x2][y1 - 1] + ocean[x1 - 1][y1 - 1];
        	int iCount = ice[x2][y2] - ice[x1 - 1][y2] - ice[x2][y1 - 1] + ice[x1 - 1][y1 - 1];
        	
        	sb.append(jCount).append(" ").append(oCount).append(" ").append(iCount).append("\n");
        }
        
        System.out.println(sb);
	}
}