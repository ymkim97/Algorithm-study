import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] house = new int[N];
        
        for (int i = 0; i < N; i++) {
        	house[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(house);
        
        int answer = 0;
        
        int low = 1;
        int high = house[N - 1];
        
        while (low <= high) {
        	int mid = (low + high) / 2;
        
        	int position = 0;
            int cnt = 1;
            
            for (int i = 1; i < N; i++) {
                if (house[i] - house[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }
        	
        	if (cnt < C) high = mid - 1;
        	
        	else {
        		answer = mid;
        		low = mid + 1;
        	}
        }
        
        System.out.println(answer);
	}
}