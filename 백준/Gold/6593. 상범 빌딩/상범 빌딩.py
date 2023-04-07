import sys
from collections import deque

input = sys.stdin.readline

def bfs(a, b, c):
    global time
    global building

    q = deque()
    q.append((a, b, c, 0))
    d = [(0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1), (1, 0, 0), (-1, 0, 0)]
    visit = [[[False] * C for _ in range(R)] for _ in range(L)]
    visit[a][b][c] = True

    while q:
        z, x, y, count = q.popleft()

        if building[z][x][y] == 'E':
            time = count
            return True

        for i in range(6):
            dz = z + d[i][0]
            dx = x + d[i][1]
            dy = y + d[i][2]

            if 0 <= dz < L and 0 <= dx < R and 0 <= dy < C and building[dz][dx][dy] != '#' and not visit[dz][dx][dy]:
                visit[dz][dx][dy] = True
                q.append((dz, dx, dy, count + 1))

    return False

while True:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        break

    time = 0
    isEscape = False
    building = []

    for i in range(L):
        floor = [list(input().strip()) for _ in range(R)]
        building.append(floor)
        line = input()

    for i in range(L):
        for j in range(R):
            for k in range(C):
                if building[i][j][k] == 'S':
                    isEscape = bfs(i, j, k)
                    break

    if not isEscape:
        print("Trapped!")
    else:
        print(f"Escaped in {time} minute(s).")