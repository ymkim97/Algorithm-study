import sys
from collections import deque

input = sys.stdin.readline

maxValue = 100000
N, K = map(int, input().split())
visit = [0] * 100001
track = [0] * 100001
ansTrack = []

def bfs(start, end):
    global ansTime

    q = deque()
    q.append(start) 

    while q:

        now = q.popleft()

        if now == end:  
            return

        for i in (now - 1, now + 1, now * 2):
            if 0 <= i <= maxValue and not visit[i]:
                visit[i] = visit[now] + 1
                track[i] = now
                q.append(i)

bfs(N, K)

index = K
for i in range(visit[K] + 1):
    ansTrack.append(index)
    index = track[index]

print(visit[K])
print(*ansTrack[::-1])