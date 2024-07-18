import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String first = br.readLine();
        String second = br.readLine();
        
        String str1 = "";
        String str2 = "";
        
        for (int i = 0; i < second.length(); i++) {
        	str1 += first;
        }
        
        for (int i = 0; i < first.length(); i++) {
        	str2 += second;
        }
        
        System.out.println(str1.equals(str2) ? 1 : 0); 
	}
}