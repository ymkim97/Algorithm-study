import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
gears = [deque(map(int, input().strip())) for _ in range(T)]
K = int(input())
movement = [list(map(int, input().split())) for _ in range(K)]
answer = 0

for move in movement:
    gearNum, direction = move
    gearNum -= 1
    tmpRotate = []

    tmpRotate.append((gearNum, direction))

    # 왼쪽으로
    tmp = gearNum
    while True and gearNum != 0:

        if gears[tmp][6] != gears[tmp - 1][2]:
            tmpRotate.append((tmp - 1, -tmpRotate[-1][1]))

        else:
            break

        if tmp == 1:
            break

        tmp -= 1

    # 오른쪽으로
    tmp = gearNum
    while True and gearNum != T - 1:

        if gears[tmp][2] != gears[tmp + 1][6]:
            if tmp == gearNum:
                tmpRotate.append((tmp + 1, -direction))
            else:
                tmpRotate.append((tmp + 1, -tmpRotate[-1][1]))

        else:
            break

        if tmp == T - 2:
            break

        tmp += 1

    for eachRotate in tmpRotate:
        gears[eachRotate[0]].rotate(eachRotate[1])

for each in gears:
    answer += each[0]
    
print(answer)