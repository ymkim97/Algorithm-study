import sys
import heapq

input = sys.stdin.readline

N, M, X = map(int, input().split())

village = [[] for _ in range(N + 1)]
distance = [[]]
distance2 = [float('inf')] * (N + 1)
answer = 0

for _ in range(M):
    start, end, time = map(int, input().split())
    village[start].append((end, time))

def dijkstra(tmpDistance, start):
    
    q = []
    heapq.heappush(q, (0, start))
    tmpDistance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if tmpDistance[now] < dist:
            continue

        for i in village[now]:
            newDis = dist + i[1]
            if newDis < tmpDistance[i[0]]:
                tmpDistance[i[0]] = newDis
                heapq.heappush(q, (newDis, i[0]))

    return tmpDistance

for i in range(1, N + 1):
    distance.append(dijkstra([float('inf')] * (N + 1), i))

distance2 = dijkstra(distance2, X)

for i in range(1, N + 1):
    answer = max(answer, distance[i][X] + distance2[i])

print(answer)