import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (lis.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                lis.set(left, arr[i]);
            }
        }

        System.out.println(lis.size());
    }
}