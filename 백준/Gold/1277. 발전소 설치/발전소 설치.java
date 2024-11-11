import java.util.*;
import java.io.*;

class Main {
	
	static double INF = 987654321;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        double M = Double.parseDouble(br.readLine());
        
        Point[] points = new Point[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	points[i] = new Point(i, x, y);
        }
        
        double[][] graph = new double[N + 1][N + 1];
        
        for (double[] r : graph) {
        	Arrays.fill(r, INF);
        }
        
        for (int i = 1; i <= N; i++) {
        	Point p1 = points[i];
        	
        	for (int j = i + 1; j <= N; j++) {
        		Point p2 = points[j];
        		
        		double dist = p1.getDistance(p2);
        		
        		if (dist <= M) graph[i][j] = graph[j][i] = dist;
        	}
        }
        
        for (int i = 0; i < W; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph[a][b] = graph[b][a] = 0;
        }
        
        // Dijkstra
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        Point[] dist = new Point[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	Point p = new Point(i, INF);
        	
        	if (i == 1) {
        		p.cumDist = 0;
        		pq.offer(p);
        	}
        	
        	dist[i] = p;
        }
        
        while (!pq.isEmpty()) {
        	Point now = pq.poll();
        	
        	for (int i = 1; i <= N; i++) {
        		if (graph[now.num][i] != INF && dist[i].cumDist > dist[now.num].cumDist + graph[now.num][i]) {
        			dist[i].cumDist = dist[now.num].cumDist + graph[now.num][i];
        			pq.offer(dist[i]);
        		}
        	}
        }
        
        System.out.println(dist[N].cumDist == INF ? -1 : (int)(dist[N].cumDist * 1000));
	}
	
	static class Point implements Comparable<Point>{
		int num;
		int x;
		int y;
		double cumDist;
		
		public Point(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
		
		public Point(int num, double cumDist) {
			this.num = num;
			this.cumDist = cumDist;
		}
		
		public double getDistance(Point o) {
			long d1 = this.x - o.x;
			long d2 = this.y - o.y;
			
			return Math.sqrt(d1 * d1 + d2 * d2);
		}

		@Override
		public int compareTo(Point o) {
			return Double.compare(this.cumDist, o.cumDist);
		}
	}
}
