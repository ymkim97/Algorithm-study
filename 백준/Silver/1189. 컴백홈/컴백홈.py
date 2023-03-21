import sys

input = sys.stdin.readline

R, C, K = map(int, input().split())
road = [list(input().strip()) for _ in range(R)]
visit = [[False] * C for _ in range(R)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
answer = 0

def backtrack(x, y, count):
    global answer

    if count == K:
        if x == 0 and y == C - 1:
            answer += 1
        return
    
    for i in range(4):
        dx = x + d[i][0]
        dy = y + d[i][1]
        
        if 0 <= dx < R and 0 <= dy < C and visit[dx][dy] == False and road[dx][dy] != 'T':
            visit[dx][dy] = True
            backtrack(dx, dy, count + 1)
            visit[dx][dy] = False    

visit[R - 1][0] = True
backtrack(R - 1, 0, 1)
print(answer)