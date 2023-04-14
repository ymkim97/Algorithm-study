import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
population = [0] + list(map(int, input().split()))
nextTo = [[]]
answer = float('inf')

for _ in range(N):
    x = list(map(int, input().split()))
    nextTo.append(x[1:])

def bfs(group):

    q = deque()
    q.append(group[0])
    visit = [False] * (N + 1)
    visit[group[0]] = True
    people = 0
    cnt = 1

    while q:
        x = q.popleft()
        people += population[x]

        for nx in nextTo[x]:
            if nx in group and not visit[nx]:
                visit[nx] = 1
                cnt += 1
                q.append(nx)
        
    if (cnt == len(group)):
        return people
    else:
        return 0

def dfs(count, x, end):
    global answer

    if count == end:
        group1, group2 = [], []
        # 구역 나누기
        for i in range(1, N + 1):
            if lnk[i]:
                group1.append(i)
            else:
                group2.append(i)
        
        ans1 = bfs(group1)
        if not ans1:
            return
        ans2 = bfs(group2)
        if not ans2:
            return
        
        answer = min(answer, abs(ans1 - ans2))
        return

    for i in range(x, N + 1):
        if lnk[i]:
            continue

        lnk[i] = 1
        dfs(count + 1, i, end)
        lnk[i] = 0

for i in range(1, N // 2 + 1):
    lnk = [0 for _ in range(N + 1)]
    dfs(0, 1, i)

if answer == float('inf'):
    print(-1)
else:
    print(answer)