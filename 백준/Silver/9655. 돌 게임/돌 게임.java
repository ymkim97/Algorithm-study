import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		if (Integer.parseInt(br.readLine()) % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}
