import sys

input = sys.stdin.readline

N = int(input())

pot = [list(map(int, input().split())) for _ in range(N)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
answer = float('inf')

def check(x, y, visited):
    for i in range(4):
        dx = x + d[i][0]
        dy = y + d[i][1]
        if (dx, dy) in visited:
            return False
    return True

def dfs(visited, total):
    global answer

    if total >= answer:
        return
    if len(visited) == 15:
        answer = min(answer, total)

    for i in range(1, N - 1):
        for j in range(1, N - 1):
            if check(i, j, visited) and (i, j) not in visited:
                tmp = [(i, j)]
                tmpCost = pot[i][j]
                for k in range(4):
                    di = i + d[k][0]
                    dj = j + d[k][1]
                    tmp.append((di, dj))
                    tmpCost += pot[di][dj]

                dfs(visited + tmp, total + tmpCost)
dfs([], 0)
print(answer)