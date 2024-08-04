import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int fatigue = 0;
        int time = 0;
        int workDone = 0;
        
        while (time < 24) {
        	if (fatigue < 0) fatigue = 0;
        	
        	if (fatigue + A <= M) {
        		workDone += B;
        		fatigue += A;
        	}
        	
        	else {
        		fatigue -= C;
        	}
        	
        	time += 1;
        }
        
        System.out.println(workDone);
	}
}