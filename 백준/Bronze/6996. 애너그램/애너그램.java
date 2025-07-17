import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            if (first.length() != second.length()) return false;

            for (int i = 0; i < first.length(); i++) {
                arr1[first.charAt(i) - 'a'] += 1;
                arr2[second.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }

            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
