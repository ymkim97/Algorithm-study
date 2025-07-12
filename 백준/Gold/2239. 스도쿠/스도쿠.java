import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] board = new int[9][9];
        List<int[]> zeros = new ArrayList<>(); 

        
        for (int i = 0; i < 9; i++) {
        	char[] input = br.readLine().toCharArray();
        	
        	for (int j = 0; j < 9; j++) {
        		board[i][j] = input[j] - '0';
        		
        		if (board[i][j] == 0) zeros.add(new int[] {i, j});
        	}
        }
        
        dfs(board, 0, zeros);
	}
	
	private static void dfs(int[][] board, int depth, List<int[]> zeros) {
		if (depth == zeros.size()) {
			for (int i = 0; i < 9; i++) {
			    for (int j = 0; j < 9; j++) {
			    	System.out.print(board[i][j]);
			    }
			    System.out.println();
			}
			
			System.exit(0);
		}
		
		int x = zeros.get(depth)[0];
		int y = zeros.get(depth)[1];
		
		for (int i = 1; i <= 9; i++) {
			if (checkRow(board, i, x) && checkCol(board, i, y) && checkSquare(board, i, x, y)) {
				board[x][y] = i;
				dfs(board, depth + 1, zeros);
				board[x][y] = 0;
			}
		}
	}
	
	private static boolean checkRow(int[][] board, int num, int r) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == num) return false;
		}
		
		return true;
	}
	
	private static boolean checkCol(int[][] board, int num, int c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == num) return false;
		}
		
		return true;
	}
	
	private static boolean checkSquare(int[][] board, int num, int x, int y) {
		int startX = x / 3 * 3;
		int startY = y / 3 * 3;
		
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (board[i][j] == num) return false;
			}
		}
		
		return true;
	}
}
