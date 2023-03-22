from collections import deque
import sys

input = sys.stdin.readline

A, B = map(int, input().split())
count = -1

q = deque()
q.append((A, 1))

while q:

    x, cnt = q.popleft()

    if x == B:
        count = cnt
        break

    if x * 2 <= B:
        q.append(((x * 2), cnt + 1))
    
    if (10 * x) + 1 <= B:
        q.append(((10 * x) + 1, cnt + 1))

print(count)