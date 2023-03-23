import sys

input = sys.stdin.readline

R, C, M = map(int, input().split())
answer = 0
graph = [[0] * C for _ in range(R)]
shark = [list([] for _ in range(C)) for _ in range(R)]

# 상하우좌
direction = [(-1, 0), (1, 0), (0, 1), (0, -1)]

for _ in range(M):
    r, c, s, d, z = map(int, input().split())
    graph[r - 1][c - 1] = 1
    # 0속도, 1방향, 2크기
    shark[r - 1][c - 1].append((s, d - 1, z))

def moveShark():

    movedGraph = [[0] * C for _ in range(R)]

    for i in range(R):
        for j in range(C):
            # 상어가 있으면
            if graph[i][j]:
                x, y = i, j
                s, d, z = shark[i][j][0]
                moved = s

                while moved > 0:
                    nx = x + direction[d][0]
                    ny = y + direction[d][1]

                    if 0 <= nx < R and 0 <= ny < C:
                        x, y = nx, ny
                        moved -= 1
                    
                    else:
                        if d == 0 or d == 2:
                            d += 1
                        elif d == 1 or d == 3:
                            d -= 1
                
                movedGraph[x][y] += 1
                del shark[i][j][0]
                shark[x][y].append((s, d, z))
                
    for i in range(R):
        for j in range(C):
            graph[i][j] = movedGraph[i][j]
    
for i in range(C):
    # 현재 위치
    position = i

    # 가까운 상어 잡기
    for a in range(R):
        if graph[a][i] == 1:
            answer += shark[a][i][0][2]
            graph[a][i] = 0
            del shark[a][i][0]
            break

    # 상어들 이동하기
    moveShark()

    # 겹치는 상어 제거
    for m in range(R):
        for n in range(C):
            if graph[m][n] > 1:
                shark[m][n].sort(key = lambda x : x[2], reverse=True)
                while len(shark[m][n]) != 1:
                    shark[m][n].pop()
                graph[m][n] = 1                
                
print(answer)