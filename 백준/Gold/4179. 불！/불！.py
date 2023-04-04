import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())

wall = [list(input().strip()) for _ in range(R)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
fire = []
visit = [[False] * C for _ in range(R)]
m, n = 0, 0
time = 0
escape = False

def bfs(a, b):
    global time
    global escape
    global fire

    q = deque()
    q2 = deque()
    q.append((a, b))
    for each in fire:
        q.append(each)

    while q:
        x, y = q.popleft()

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if wall[x][y] == 'J':
                if dx < 0 or dx >= R or dy < 0 or dy >= C:
                    time += 1
                    escape = True
                    return

                if 0 <= dx < R and 0 <= dy < C and wall[dx][dy] == '.':
                    wall[dx][dy] = 'J'
                    q2.append((dx, dy))

            elif wall[x][y] == 'F':
                visit[x][y] = True
                if 0 <= dx < R and 0 <= dy < C and wall[dx][dy] != '#' and not visit[dx][dy]:
                    wall[dx][dy] = 'F'
                    visit[dx][dy] = True
                    fire.append((dx, dy))
                    q2.append((dx, dy))

        if len(q) == 0:
            time += 1
            q = deque([arr[:] for arr in q2])
            q2 = deque()

for i in range(R):
    for j in range(C):
        if wall[i][j] == 'J':
            m, n = i, j
        if wall[i][j] == 'F':
            fire.append((i, j))

bfs(m, n)

if escape:
    print(time)
else:
    print("IMPOSSIBLE")