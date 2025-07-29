import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        List<Integer> shareCard = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	shareCard.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> teamCard = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	teamCard.add(Integer.parseInt(st.nextToken()));
        }
        
        List<TeamNode> products = new ArrayList<>();
        
        for (int n : shareCard) {
        	for (int m : teamCard) {
        		products.add(new TeamNode(m, n * m));
        	}
        }
        
        for (int i = 0; i < K; i++) {
        	Collections.sort(products, (a, b) -> b.prod - a.prod);
        	TeamNode node = products.get(0);
        	
        	List<TeamNode> tmp = new ArrayList<>();
        	
        	for (TeamNode n : products) {
        		if (n.card!= node.card) tmp.add(n);
        	}
        	
        	products = tmp;
        }
        
        System.out.println(products.get(0).prod);
    }
    
    static class TeamNode {
    	int card;
    	int prod;
    	
    	public TeamNode(int card, int prod) {
    		this.card = card;
    		this.prod = prod;
    	}
    }
}
