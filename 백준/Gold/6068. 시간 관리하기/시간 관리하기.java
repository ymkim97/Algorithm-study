import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        List<Node> lst = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int t = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	
        	lst.add(new Node(t, s));
        }
        
        Collections.sort(lst, (a, b) -> b.s - a.s);
        
        int answer = lst.get(0).s - lst.get(0).t;
        
        for (int i = 1; i < N; i++) {
        	Node now = lst.get(i);
        	
        	if (now.s < answer) answer = now.s;
        		
        	answer -= now.t;
        }
        
        System.out.println(answer < 0 ? -1 : answer);
 	}
	
	static class Node {
		int t;
		int s;
		
		public Node(int t, int s) {
			this.t = t;
			this.s = s;
		}
	}
}