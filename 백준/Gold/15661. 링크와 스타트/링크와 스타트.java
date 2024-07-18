import java.util.*;
import java.io.*;

class Main {
	
	static int[][] powers;
	static int N;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        powers = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		powers[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 1; i <= N / 2; i++) {
        	backtrack(i, 0, -1, new boolean[N]);
        }
        
        System.out.println(answer);
	}
	
	public static void backtrack(int teamMemberCnt, int tmpCnt, int lastIdx, boolean[] isTeam) {
		if (teamMemberCnt == tmpCnt) {
			int aTeam = 0;
			int bTeam = 0;
			
			for (int i = 0; i < N; i++) {
				if (isTeam[i]) {
					for (int j = i + 1; j < N; j++) {
						if (isTeam[j]) {
							aTeam += powers[i][j] + powers[j][i];
						}
					}
				}
				
				else {
					for (int j = i + 1; j < N; j++) {
						if (!isTeam[j]) {
							bTeam += powers[i][j] + powers[j][i];
						}
					}
				}
			}
			
			answer = Math.min(answer, Math.abs(aTeam - bTeam));
			return;
		}
		
		for (int i = lastIdx + 1; i < N; i++) {
			if (!isTeam[i]) {
				isTeam[i] = true;
				backtrack(teamMemberCnt, tmpCnt + 1, i, isTeam);
				isTeam[i] = false;
			}
		}
	}
}