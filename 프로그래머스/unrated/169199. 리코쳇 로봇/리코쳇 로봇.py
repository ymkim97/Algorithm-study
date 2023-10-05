from collections import deque

def solution(board):
    d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    visited = [[0] * len(board[0]) for _ in range(len(board))]
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == "R":
                rx, ry = i, j
                
    q = deque()
    q.append((rx, ry))
    visited[rx][ry] = 1
    
    while q:
        x, y = q.popleft()
        
        if board[x][y] == "G":
            return visited[x][y] - 1
        
        for i in range(4):
            dx, dy = x, y
            
            while True:
                dx += d[i][0]
                dy += d[i][1]
                
                if dx < 0 or dx >= len(board) or dy < 0 or dy >= len(board[0]):
                    dx -= d[i][0]
                    dy -= d[i][1]
                    break
                
                if 0 <= dx < len(board) and 0 <= dy < len(board[0]) and board[dx][dy] == "D":
                    dx -= d[i][0]
                    dy -= d[i][1]
                    break
    
            if not visited[dx][dy]:
                visited[dx][dy] = visited[x][y] + 1
                q.append((dx, dy))
    
    return -1