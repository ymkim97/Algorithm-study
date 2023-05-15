import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

fishes = [list(map(int, input().split())) for _ in range(N)]
sharkWeight = 2
food = 0
time = 0
INF = float('inf')
d = [(-1, 0), (0, -1), (0, 1), (1, 0)]

for i in range(N):
    for j in range(N):
        if fishes[i][j] == 9:
            sharkX, sharkY = i, j
            fishes[i][j] = 0

def move():
    visit = [[-1] * N for _ in range(N)]

    q = deque()
    q.append((sharkX, sharkY))
    visit[sharkX][sharkY] = 0

    while q:
        x, y = q.popleft()

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if 0 <= dx < N and 0 <= dy < N and visit[dx][dy] == -1 and fishes[dx][dy] <= sharkWeight:
                visit[dx][dy] = visit[x][y] + 1
                q.append((dx, dy))

    return visit

def solve(visit):
    x, y = 0, 0
    min_dis = INF
    for i in range(N):
        for j in range(N):
            if visit[i][j] != -1 and 1 <= fishes[i][j] < sharkWeight:
                if visit[i][j] < min_dis:
                    min_dis = visit[i][j]
                    x, y = i, j

    if min_dis == INF:
        return False

    else:
        return x, y, min_dis

while True:
    result = solve(move())

    if not result:
        print(time)
        break

    sharkX, sharkY = result[0], result[1]
    time += result[2]
    fishes[sharkX][sharkY] = 0
    food += 1

    if food >= sharkWeight:
        sharkWeight += 1
        food = 0  
