import java.util.*;
import java.io.*;

class Main {
	
	static int answer = Integer.MAX_VALUE;
	static int maxPlay = 0;
	static int M, N;
	static List<int[]> lst;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lst = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	String name = st.nextToken();
        	String avail = st.nextToken();
        	
        	int[] tmp = new int[M];
        	
        	for (int j = 0; j < M; j++) {
        		tmp[j] = avail.charAt(j) == 'Y' ? 1 : 0;
        	}
        	
        	lst.add(tmp);
        }
        
        Collections.sort(lst, (a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum());
        
        if (Arrays.stream(lst.get(0)).sum() == 0) {
        	System.out.println(-1);
        	return;
        }
        
        bruteforce(-1, 0, new int[M]);
        
        System.out.println(answer);
	}
	
	public static void bruteforce(int idx, int guitarCount, int[] play) {
		int tmpSum = Arrays.stream(play).sum();
		
		if (tmpSum > maxPlay) {
			maxPlay = tmpSum;
			answer = guitarCount;
		}
		
		else if (tmpSum == maxPlay) {
			answer = Math.min(answer, guitarCount);
		}
		
		if (tmpSum == M) return;
		
		for (int i = idx + 1; i < N; i++) {
			int[] tmp = Arrays.copyOf(play, play.length);
			int[] next = lst.get(i);
			
			for (int j = 0; j < M; j++) {
				tmp[j] += next[j];
				if (tmp[j] == 2) tmp[j] = 1;
			}
			
			bruteforce(i, guitarCount + 1, tmp);
		}
	}
}