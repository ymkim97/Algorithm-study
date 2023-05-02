import sys

input = sys.stdin.readline

R, C, N = map(int, input().split())
init = [list(input().strip()) for _ in range(R)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
cnt = 1

while cnt != N:
    cnt += 1
    if cnt % 2 == 0:
        newBomb = [['O'] * C for _ in range(R)]
        continue

    bombLst = []
    noTouch = [[False] * C for _ in range(R)]

    for i in range(R):
        for j in range(C):
            if init[i][j] == 'O':
                bombLst.append((i, j))
                noTouch[i][j] = True

    for x, y in bombLst:
        
        newBomb[x][y] = '.'
        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]

            if 0 <= dx < R and 0 <= dy < C and newBomb[dx][dy] == 'O' and not noTouch[dx][dy]:
                newBomb[dx][dy] = '.'
    
    init = [arr[:] for arr in newBomb]

if N % 2 == 0:
    for each in newBomb:
        print(''.join(each))    

else:
    for each in init:
        print(''.join(each))