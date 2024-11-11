import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;
        
        int n = Integer.parseInt(br.readLine());
        
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        
        List<int[]> trees = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	trees.add(new int[] {Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())});
        }
        
        Collections.sort(trees, (a, b) -> a[1] - b[1]);
        
        long answer = 0;
        
        for (int i = 0; i < n; i++) {
        	answer += (trees.get(i)[0] + trees.get(i)[1] * i);
        }
        
        System.out.println(answer);
	}
}
