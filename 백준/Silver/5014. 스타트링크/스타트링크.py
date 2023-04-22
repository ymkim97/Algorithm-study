import sys
from collections import deque

input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())

visited = [0] * (F + 1)
answer = float('inf')

def bfs():
    global answer
    q = deque()
    q.append(S)

    while q:
        x = q.popleft()
        
        if x == G:
            answer = visited[G]
            break
        
        for i in (U, -D):

            if 1 <= x + i <= F and not visited[x + i] and x + i != S:
                visited[x + i] = visited[x] + 1
                q.append(x + i)

bfs()
print(answer if answer != float('inf') else "use the stairs")