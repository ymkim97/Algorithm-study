import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	public static class location{
		int x;
    	int y;
		public location(int y , int x) {
    		this.x = x;
    		this.y = y;
    	}
    }
    public static StringBuilder sb = new StringBuilder();
    public static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    static int[][] garden;
    static int[][] visited;
    static int dy[] = { 1,-1,0,0 };
    static int dx[] = { 0,0,1,-1 };
    static int ans = 0;
    static int M;
    static int N;
    static int G;
    static int R;
    static Stack<Integer> combinationSet = new Stack<Integer>();
    static ArrayList<location> CanSparge = new ArrayList<location>();
    static Queue<location> WheretoSparge = new LinkedList<location>();
    
    public static void main(String[] args)throws Exception {
    	 String lines = br.readLine();
         String[] spl  = lines.split(" ");
         N=Integer.parseInt(spl[0]);
         M=Integer.parseInt(spl[1]);
         G=Integer.parseInt(spl[2]);	
         R=Integer.parseInt(spl[3]); 
         
         garden = new int[N][M];
         visited = new int[N][M];
         
         for(int i=0; i<N; i++) {
        	 lines = br.readLine().trim();
             spl = lines.split(" ");
             for(int j=0; j<M; j++) {
             	garden[i][j] = Integer.parseInt(spl[j]);
             	//배양액 살포 가능한 땅 저장하기
             	if(garden[i][j] ==2) {
             		CanSparge.add(new location(i,j));
             		garden[i][j] = 1;
             	}
             	visited[i][j] = 9876;
             }
         }
         choose();
         System.out.println(ans);
    }

	public static void spread() {
	    
		location liquid;
		int flowers = 0;
		int time = 1;
		
		while(!WheretoSparge.isEmpty()) {
            //이거 한번 돌때마다 1 time
			int size = WheretoSparge.size();
			for(int i=0; i< size; i++) {
				
				liquid = WheretoSparge.poll();
				int x = liquid.x;
				int y = liquid.y;
                
				//꽃이면 continue
				if(visited[y][x] == -1) continue;
                
				for(int k =0; k< 4; k++) {
					int nextdy = y + dy[k];
					int nextdx = x + dx[k];
					
                    //얘가 퍼질곳의 범위 확인
					if(nextdy > N-1 || nextdy < 0 || nextdx > M-1 || nextdx < 0) continue;
                    //물이면 패스
					if(garden[nextdy][nextdx] == 0)  continue;
					
					if(garden[nextdy][nextdx] == 1) {
						WheretoSparge.add(new location(nextdy, nextdx));
                        //만약에 퍼지면, 퍼졋다고 미리 체크(다른 배양액이 퍼지지 못하게)
						garden[nextdy][nextdx] = garden[y][x];
						visited[nextdy][nextdx] = time;
					}
                    //만약에 똑같은 시간에 퍼졌고, 같은 배양액이 아니면 == 꽃이 생김
					else if(visited[nextdy][nextdx] == time && garden[nextdy][nextdx] != garden[y][x]) {
						garden[nextdy][nextdx] = 10;
						visited[nextdy][nextdx] = -1;
						flowers++;
					}					
				}				
			}
			//시간 증가
			time++;
		}

		//기존의 정원으로 되돌리기
		for(int y = 0; y < N; y++) {
			for(int x = 0 ; x < M; x++) {
				if(garden[y][x] > 1) garden[y][x] = 1;
				visited[y][x] = 9876;
			}
		}
		ans = Math.max(ans, flowers);
	}
	
    public static void choose() {
    	int[] arr = new int[R+G];
    	combination(arr, 0, CanSparge.size(), R+G, 0);
    }
    
	//R+G개 조합
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r==0) {
			int[] red = new int[R];
			combination2(red, 0, R+G, R, 0, arr);
		}
		else if (target == n) return;
		else {
			arr[index] = target;
			combination(arr, index+1, n, r-1, target+1);
			combination(arr, index, n, r, target+1);
		}
	}
	
	//R개 조합
	public static void combination2(int [] arr, int index, int n, int r, int target, int[] range) {
		if (r==0) {
			for(int i = 0; i < arr.length; i++) {
				//넣을때 부터 정원, 방문횟수 초기화
				garden[CanSparge.get(range[arr[i]]).y][CanSparge.get(range[arr[i]]).x] = 11;
				visited[CanSparge.get(range[arr[i]]).y][CanSparge.get(range[arr[i]]).x] = 0;
				WheretoSparge.add(CanSparge.get(range[arr[i]]));
			}
			for(int i = 0; i < range.length ; i++) {
				for(int i2 = 0; i2 < arr.length; i2++) {
					if(i == arr[i2]) i++;
				}
				if(i >= range.length) break;
				//넣을때 부터 정원, 방문횟수 초기화
				garden[CanSparge.get(range[i]).y][CanSparge.get(range[i]).x] = 99;
				visited[CanSparge.get(range[i]).y][CanSparge.get(range[i]).x] = 0;
				WheretoSparge.add(CanSparge.get(range[i]));
			}
			spread();
			WheretoSparge.clear();	
			return;
		}
		else if (target == n) return;
		else {
			//range의 주소가 들어감
			arr[index] = target;
			combination2(arr, index+1, n, r-1, target+1, range);
			combination2(arr, index, n, r, target+1, range);
		}
	}	
	public static void print(int[][] board) {
        StringBuilder sb2 = new StringBuilder();
		for(int y = 0; y < N; y++) {
			for(int x = 0 ; x < M; x++) {
				sb2.append(board[y][x]+" ");
			}
			sb2.append("\n");	
		}
		System.out.println(sb2.toString());
	}
}