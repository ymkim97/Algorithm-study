import java.io.*;
import java.util.*;

class Main {
	
	static int N;
    static int[] arr;

	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long cnt = 0;
        for(int i = 0; i < N - 1; i++) {
            cnt += binarySearch(i) - i;
        }

        System.out.println(cnt);
    }

    public static int binarySearch(int s) {
        int left = s + 1, right = N - 1, middle = 0, ans = left;

        if(arr[s] * 10 < 9 * arr[s + 1])
            return s;

        while (left <= right) {
        	
            middle = (left + right) /2;

            if(arr[s] <= arr[middle] && arr[s] * 10 >= 9 * arr[middle]) {
                ans = middle;
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
            
        }

        return ans;
    }
}