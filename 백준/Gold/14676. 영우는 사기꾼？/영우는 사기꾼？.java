import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer>[] child = new ArrayList[N + 1];
        int[] indegree = new int[N + 1]; // 값이 0 이어야 건설 가능
        
        for (int i = 0; i <= N; i++) {
        	child[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	indegree[y]++;
        	child[x].add(y);
        }
        
        int[] built = new int[N + 1];
        
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int cmd = Integer.parseInt(st.nextToken());
        	int currentBuilding = Integer.parseInt(st.nextToken());
        	
        	if (cmd == 1 && indegree[currentBuilding] != 0 || cmd == 2 && built[currentBuilding] == 0) { // 선필수 빌딩이 없을때 Or 없는 빌딩 파괴할때
        		System.out.println("Lier!");
        		return;
        	}
        	
        	if (cmd == 1) {
        		if (built[currentBuilding] == 0) {
        			for (int c : child[currentBuilding]) {
            			indegree[c]--;
            		}
    			}
        		
        		built[currentBuilding]++;
        	}
        	
        	else if (cmd == 2) {
        		built[currentBuilding]--;
        		
        		if (built[currentBuilding] == 0) {
        			for (int c : child[currentBuilding]) {
        				indegree[c]++;
        			}
        		}
        	}
        }
        
        System.out.println("King-God-Emperor");
	}
}