import sys
from collections import deque

input = sys.stdin.readline
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

start = ""

for _ in range(3):
    tmp = input().strip()
    tmp = tmp.replace(" ", "")
    start += tmp

start = start.replace("0", "9")

q = deque()
q.append(start)

cntDict = dict()
cntDict[start] = 0

def bfs():

    while q:
        now = q.popleft()

        if now == "123456789":
            return cntDict[now]

        pos = now.find("9")
        x = pos // 3
        y = pos % 3

        for i in range(4):
            nx = x + d[i][0]
            ny = y + d[i][1]

            if 0 <= nx < 3 and 0 <= ny < 3:
                nPos = nx * 3 + ny

                nextNum = list(now)
                nextNum[nPos], nextNum[pos] = nextNum[pos], nextNum[nPos]
                nextNum = "".join(nextNum)

                if not cntDict.get(nextNum):
                    q.append(nextNum)
                    cntDict[nextNum] = cntDict[now] + 1

result = bfs()
print(result if result != None else -1)