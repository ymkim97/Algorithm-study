import java.io.*;
import java.util.*;

public class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;

        while (true) {
            BlockGroup group = findBiggestBlockGroup(board);

            if (group == null) break;

            score += removeBlockGroup(group, board);

            operateGravity(board);

            board = rotate90Degrees(board);

            operateGravity(board);
        }

        System.out.println(score);
    }

    private static BlockGroup findBiggestBlockGroup(int[][] board) {
        boolean[][] visited = new boolean[board.length][board.length];

        List<BlockGroup> groups = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!visited[i][j] && board[i][j] != -1 && board[i][j] != -2 && board[i][j] != 0) {
                    BlockGroup b = bfs(i, j, board, visited, board[i][j]);
                    if (b != null) groups.add(b);
                }
            }
        }

        if (groups.isEmpty()) return null;

        Collections.sort(groups, (a, b) -> {
            if (a.blocks.size() != b.blocks.size()) return b.blocks.size() - a.blocks.size();
            else if (a.rainbowBlockCount != b.rainbowBlockCount) return b.rainbowBlockCount - a.rainbowBlockCount;
            else if (a.startX != b.startX) return b.startX - a.startX;

            return b.startY - a.startY;
        });

        return groups.get(0);
    }

    private static BlockGroup bfs(int a, int b, int[][] board, boolean[][] visited, int num) {
        boolean[][] rainbowVisited = new boolean[board.length][board.length];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> blocks = new ArrayList<>();
        visited[a][b] = true;

        int rainbowCount = 0;

        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            if (board[x][y] != 0) blocks.add(new int[] {x, y, 1});
            else blocks.add(new int[] {x, y, 0});

            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];

                if (dx < 0 || dy < 0 || dx >= board.length || dy >= board.length || visited[dx][dy] || rainbowVisited[dx][dy] || board[dx][dy] == -1 || board[dx][dy] == -2) continue;
                if (board[dx][dy] != 0 && board[dx][dy] != num) continue;

                if (board[dx][dy] == 0) {
                    rainbowCount += 1;
                    rainbowVisited[dx][dy] = true;
                } else if (board[dx][dy] == num) {
                    visited[dx][dy] = true;
                }

                q.offer(new int[] {dx, dy});
            }
        }

        if (blocks.size() == 1) return null;

        BlockGroup bg = new BlockGroup();
        bg.blocks = blocks;
        bg.rainbowBlockCount = rainbowCount;
        bg.findStartPoint();

        return bg;
    }

    static int removeBlockGroup(BlockGroup group, int[][] board) {
        for (int[] block : group.blocks) {
            int x = block[0];
            int y = block[1];

            board[x][y] = -2;
        }

        return group.blocks.size() * group.blocks.size();
    }

    static void operateGravity(int[][] board) {
        for (int i = board.length - 2; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != -1 && board[i + 1][j] == -2) {
                    int x = i + 1;

                    while (x + 1 < board.length && board[x + 1][j] == -2) {
                        x += 1;
                    }

                    board[x][j] = board[i][j];
                    board[i][j] = -2;
                }
            }
        }
    }

    static int[][] rotate90Degrees(int[][] board) {
        int[][] newBoard = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                newBoard[i][j] = board[j][board.length - i - 1];
            }
        }

        return newBoard;
    }

    static class BlockGroup {
        int rainbowBlockCount = 0;
        int startX;
        int startY;
        List<int[]> blocks;

        public void findStartPoint() {
            Collections.sort(blocks, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];

                return a[0] - b[0];
            });

            for (int[] block : blocks) {
                if (block[2] == 1) {
                    startX = block[0];
                    startY = block[1];
                    break;
                }
            }

        }

        @Override
        public String toString() {
            return "X: " + startX + " Y: " + startY;
        }
    }
}