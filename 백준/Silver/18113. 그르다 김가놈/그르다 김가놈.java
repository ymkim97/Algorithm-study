import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer> lst = new ArrayList<>();
        
        int high = 0;
        
        for (int i = 0; i < N; i++) {
        	int l = Integer.parseInt(br.readLine());
        	
        	if (l <= K) {
        		continue;
        	} else if (l < 2 * K) {
        		high = Math.max(high, l - K);
        		lst.add(l - K);
        	} else if (l > 2 * K){
        		lst.add(l - (2 * K));
        		high = Math.max(high, l - (2 * K));
        	}
        }
        
        if (lst.size() == 0) {
        	System.out.println(-1);
        	return;
        }
       
        int low = 1;
        
        while (low <= high) {
        	int mid = (low + high) / 2;
        	int cnt = 0;
        	
        	for (int i = 0; i < lst.size(); i++) {
        		cnt += lst.get(i) / mid;
        	}
        	
        	if (cnt >= M) {
        		low = mid + 1;
        	} else {
        		high = mid - 1;
        	}
        }
        
        System.out.println(low == 1 ? -1 : low - 1);
	}
}