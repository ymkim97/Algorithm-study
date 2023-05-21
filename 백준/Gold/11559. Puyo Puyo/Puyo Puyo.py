import sys
from collections import deque

input = sys.stdin.readline

board = [list(input().strip()) for _ in range(12)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
count = 0

def check(a, b) -> int:

    criLet = board[a][b]
    tmp = []

    q = deque()
    q.append((a, b))
    visit[a][b] = True

    while q:
        x, y = q.popleft()
        tmp.append((x, y))

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if 0 <= dx < 12 and 0 <= dy < 6 and not visit[dx][dy] and board[dx][dy] == criLet:
                visit[dx][dy] = True
                q.append((dx, dy))
                
    if len(tmp) >= 4:
        for x, y in tmp:
            board[x][y] = '.'
        
        return len(tmp)

    return 0

def reload():

    for j in range(6):
        tmp = deque()

        for i in range(11, -1, -1):
            if board[i][j] == '.':
                tmp.append(i)
            elif not len(tmp) == 0:
                newI = tmp.popleft()
                board[newI][j] = board[i][j]
                board[i][j] = '.'
                tmp.append(i)

while True:

    isAvail = 0

    visit = [[False] * 6 for _ in range(12)]

    for i in range(12):
        for j in range(6):
            if board[i][j] != '.' and not visit[i][j]:
                isAvail += check(i, j)

    if isAvail == 0:
        break

    reload()
    
    count += 1

print(count)