import java.io.*;
import java.util.*;

class Main {
    
    static List<Integer> answer = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
    
        dfs(N, 0);
        
        Collections.sort(answer);
        
        if (answer.size() == 1) {
            System.out.printf("%d %d", answer.get(0), answer.get(0));
        } else {
            System.out.printf("%d %d", answer.get(0), answer.get(answer.size() -1));
        }
    }
    
    public static void dfs(int n, int count) {
        String number = String.valueOf(n);
        char[] numbers = number.toCharArray();
        
        for (char c : numbers) {
            if (Character.getNumericValue(c) % 2 != 0) count += 1;
        }
        
        if (numbers.length == 1) {
            answer.add(count);
            return;
        } else if (numbers.length == 2) {
            dfs(Character.getNumericValue(numbers[0]) + Character.getNumericValue(numbers[1]), count);
        } else {
            for (int i = 0; i < numbers.length - 2; i++) {
                for (int j = i + 1; j < numbers.length - 1; j++) {
                    int a = Integer.parseInt(number.substring(0, i + 1));
                    int b = Integer.parseInt(number.substring(i + 1, j + 1));
                    int c = Integer.parseInt(number.substring(j + 1));
                    
                    dfs(a + b + c, count);
                }
            }
        }
    }
}
