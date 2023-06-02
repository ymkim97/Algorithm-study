import sys

input = sys.stdin.readline

N, M = map(int, input().split())
friend = [[] for _ in range(N)]
isExist = 0

for _ in range(M):
    a, b = map(int, input().split())
    friend[a].append(b)
    friend[b].append(a)

visit = [False] * N

def dfs(start, depth):
    global isExist

    if depth == 5:
        isExist = 1
        return

    for i in friend[start]:
        if not visit[i]:
            visit[i] = True
            dfs(i, depth + 1)
            visit[i] = False

    return

for i in range(N):
    if isExist == 1:
        break
    
    visit[i] = True
    dfs(i, 1)
    visit[i] = False

print(isExist)