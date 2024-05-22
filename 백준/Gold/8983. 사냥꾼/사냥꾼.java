import java.io.*;
import java.util.*;

class Main {
	
	static int M, N, L;
	static int[] point;
	static Animal[] animals;
	static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        point = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	point[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(point);
        animals = new Animal[N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	animals[i] = new Animal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < N; i++) {
        	answer += search(i);
        }
        
        System.out.println(answer);
    }
    
    public static int search(int index) {
    	int left = 0;
    	int right = M - 1;
    	Animal a = animals[index];
    	
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		
    		int p = point[mid];
    		
    		int dist = Math.abs(p - a.x) + a.y;
    		
    		if (dist <= L) return 1;
    		
    		else if (dist > L && a.x < p) {
    			right = mid - 1;
    		}
    		
    		else {
    			left = mid + 1;
    		}
    	}
    	
    	return 0;
    }
    
    static class Animal {
    	int x;
    	int y;
    	
    	public Animal(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}