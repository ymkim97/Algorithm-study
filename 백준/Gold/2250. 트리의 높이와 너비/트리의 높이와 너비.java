import java.io.*;
import java.util.*;

public class Main {
	
	static int widestLevel = 1;
	static int widest = 1;
	static Map<Integer, List<Integer>> map = new HashMap<>(); // level - col, col
	static Node[] tree;
	static String LEFT = "left";
	static String RIGHT = "right";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] in = new int[N + 1];
        
        tree = new Node[N + 1];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int num = Integer.parseInt(st.nextToken());
        	int left = Integer.parseInt(st.nextToken());
        	int right = Integer.parseInt(st.nextToken());
        	
        	if (left != -1) in[left] += 1;
        	if (right != -1) in[right] += 1;
        	
        	Node node = new Node();
        	node.num = num;
        	node.left = left;
        	node.right = right;
        	node.col = 0;
        	
        	tree[num] = node;
        }
        
        int root = 0;
        for (int i = 1; i <= N; i++) {
        	if (in[i] == 0) {
        		root = i;
        		break;
        	}
        }
        
        int leftChildCount = 0;
        
        if (tree[root].left != -1) leftChildCount += countChild(tree[tree[root].left]);
        
        tree[root].col = leftChildCount + 1;
        
        if (tree[root].left != -1) dfs(tree[tree[root].left], LEFT, tree[root].col, 2);
        if (tree[root].right != -1) dfs(tree[tree[root].right], RIGHT, tree[root].col, 2);
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        
        for (int key : keys) {
        	int level = key;
        	List<Integer> cols = map.get(key);
        	
        	if (cols.size() < 2) continue;
        	
        	Collections.sort(cols);
        	
        	int a = cols.get(cols.size() - 1);
        	int b = cols.get(0);
        	
        	int width = a - b + 1;
        	
        	if (width > widest) {
        		widest = width;
        		widestLevel = level;
        	} else if (width == widest) {
        		widestLevel = Math.min(widestLevel, level);
        	}
        }
        
        System.out.printf("%d %d", widestLevel, widest);
    }
    
    private static void dfs(Node node, String nodePosition, int parentCol, int level) {
    	if (nodePosition.equals(LEFT)) {
    		int rightChildCount = node.right != -1 ? countChild(tree[node.right]) : 0;
    		node.col = parentCol - rightChildCount - 1;
    		List<Integer> colsForLevel = map.getOrDefault(level, new ArrayList<>());
    		colsForLevel.add(node.col);
    		map.put(level, colsForLevel);
    	} else {
    		int leftChildCount = node.left != -1 ? countChild(tree[node.left]) : 0;
    		node.col = parentCol + leftChildCount + 1;
    		List<Integer> colsForLevel = map.getOrDefault(level, new ArrayList<>());
    		colsForLevel.add(node.col);
    		map.put(level, colsForLevel);
    	}
    	
    	if (node.left != -1) dfs(tree[node.left], LEFT, node.col, level + 1);
        if (node.right != -1) dfs(tree[node.right], RIGHT, node.col, level + 1);
    }
    
    private static int countChild(Node node) {
    	if (node.left == -1 && node.right == -1) return 1;
    	
    	int count = 0;
    	
    	if (node.left != -1) count += countChild(tree[node.left]);
    	if (node.right != -1) count += countChild(tree[node.right]);
    	
    	return count + 1;
    }
    
    static class Node {
    	int num;
    	int left;
    	int right;
    	int col;
    }
}
