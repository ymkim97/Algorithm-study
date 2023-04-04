import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

ground = [list(map(int, input().split())) for _ in range(N)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
answer = 0
maxNum = 0

for each in ground:
    maxNum = max(each)

def bfs(a, b, cri):
    global visit

    q = deque()
    q.append((a, b))

    while q:
        x, y = q.popleft()

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if 0 <= dx < N and 0 <= dy < N and not visit[dx][dy] and ground[dx][dy] > cri:
                visit[dx][dy] = True
                q.append((dx, dy))

for k in range(maxNum):
    visit = [[False] * N for _ in range(N)]
    tmpCount = 0
    for i in range(N):
        for j in range(N):
            if ground[i][j] > k and not visit[i][j]:
                visit[i][j] = True
                bfs(i, j, k)
                tmpCount += 1
    
    answer = max(answer, tmpCount)

print(answer)