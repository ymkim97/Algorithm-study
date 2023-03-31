import sys
from collections import deque

input = sys.stdin.readline

r, c = map(int, input().split())

cheese = [list(map(int, input().split())) for _ in range(r)]
hole = [[False] * c for _ in range(r)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
countList = []
time = 0
count = 0
tmpCount = 0

# 겉 치즈 찾기
def findOutside():
    global hole
    visit = [[False] * c for _ in range(r)]
    visit[0][0] = True

    q = deque()
    q.append((0, 0))

    while q:
        x, y = q.popleft()

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if 0 <= dx < r and 0 <= dy < c and not visit[dx][dy]:
                visit[dx][dy] = True
                if cheese[dx][dy] == 1:
                    hole[dx][dy] = True

                else:
                    q.append((dx, dy))

findOutside()
for each in hole:
    count += each.count(True)

tmpCount = count

while count != 0:

    visit = [[False] * c for _ in range(r)]
    count = 0

    for i in range(r):
        for j in range(c):
            if hole[i][j] and not visit[i][j]:
                visit[i][j] = True
                hole[i][j] = False
                cheese[i][j] = 0

    findOutside()

    for each in hole:
        count += each.count(True)

    if count != 0:
        tmpCount = count

    time += 1

print(time)
print(tmpCount)