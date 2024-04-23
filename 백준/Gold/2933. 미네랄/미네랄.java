import java.io.*;
import java.util.*;

class Main {
    
    static int R,C; //동굴의 크기
    static int N; //막대를 던진 횟수
    static char map[][];
    static int cluster[][];
    static int dx[] ={0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        } //배열 입력 (빈칸은 0, 미네랄은 -1로 표시)
        


        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int height = Integer.parseInt(st.nextToken()); //현재 던질 높이

            deleteMineral(R-height,i%2); //미네랄 지워주기
            setCluster();
        }//높이 저장

        printMap();
    }

    private static void setCluster() {
        //클러스터 찾기
        cluster = new int[R][C];
        int cnt = 1;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'x' && cluster[i][j] == 0){
                    if(findCluster(i,j,cnt)) return;
                }
                cnt++;
            }
        }
    }

    private static boolean findCluster(int row, int col, int cnt) {

        int low_height = Integer.MIN_VALUE;

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();

        queue.add(new Node(row,col));
        cluster[row][col] = cnt;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            low_height = Math.max(low_height, node.x); //제일 땅과 가까운 높이 구하기

            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx<0 || ny<0 || nx>=R || ny>=C) continue; //범위 벗어날 시 ㅌㅌ

                if(cluster[nx][ny] == 0 && map[nx][ny] == 'x'){
                    cluster[nx][ny] = cnt;
                    queue.add(new Node(nx,ny));
                }//사방향 탐색 시 미네랄 발견 시 클러스터 배열에 현재 cnt값 넣어주고 queue에도 넣어주기기
            }
            
            list.add(node); // 4방향 다 클러스터면 리스트에 넣어주기
        }
        
        if(low_height != R-1){
            downMap(list);
            return true;
        }// 클러스터가 공중에 떠 있으면 내려주기
        
        return false;
    }


    private static void printMap(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void downMap(ArrayList<Node> list) {
        int down = 1;

        for(Node node : list) map[node.x][node.y] = '.'; // 현재 클러스터 위치 일단 비워두기

        outerLoop:
        while(true){
            for(Node node : list){
                //밑으로 한 칸 내렸을 때 범위 벗어나거나
                //한 칸 내렸을 시 다른 클러스터 || 미네랄 만나면 그만 내려가야함
                if(node.x + down == R || map[node.x+down][node.y] =='x'){
                    down--;
                    break outerLoop;
                }
            }
            
            down++; //계속 내려갈 수 있음
        }
        
        for(Node node : list){
            map[node.x+down][node.y] = 'x';
        } // 내려주기

    }


    private static void deleteMineral(int height, int side) {
        //side ==0 왼쪽부터 시작
        //side ==1 오른쪽부터 시작
        
        if(side == 0){ //왼쪽부터 시작
            for(int i=0;i<C;i++){
                if(map[height][i] =='x'){
                    map[height][i] = '.';
                    return;
                }// 배열 중 미네랄 발견 시 미네랄 지워주고 break
            } 
        }
        
        else{ //오른쪽부터 시작
            for(int i=C-1;i>=0;i--){
                if(map[height][i] =='x'){
                    map[height][i] = '.';
                    return;
                }//배열 중 미네랄 발견 시 미네랄 지워주고 break
            }
        }
        
    }



    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}