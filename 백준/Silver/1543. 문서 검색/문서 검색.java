import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String document = br.readLine();
        String toFind = br.readLine();

        int count = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();

        while (right <= document.length()) {
            if (sb.length() != toFind.length()) {
                if (right == document.length()) break;
                sb.append(document.charAt(right));
                right += 1;
                continue;
            }

            if (sb.toString().equals(toFind)) {
                count += 1;
                sb = new StringBuilder();
            } else {
                if (right == document.length()) break;
                sb.append(document.charAt(right));
                sb.deleteCharAt(0);
                right += 1;
            }
        }

        System.out.println(count);
    }
}
