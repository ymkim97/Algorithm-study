import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int first = Integer.parseInt(br.readLine());
		Node root = new Node(first);
	
		while (true) {
			String input = br.readLine();
			
			if (input == null || input.isBlank()) break;
			
			root.insert(Integer.parseInt(input));
		}
		
		sb = new StringBuilder();
		
		postTraverse(root);
		
		System.out.println(sb.toString());
	}
	
	public static void postTraverse(Node node) {
		if (node == null) return;
		
		postTraverse(node.left);
		postTraverse(node.right);
		
		sb.append(node.num).append("\n");
	}
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void insert(int n) {
			if (n < num) {
				if (left == null) left = new Node(n);
				else left.insert(n);
			} else {
				if (right == null) right = new Node(n);
				else right.insert(n);
			}
		}
	}
}
