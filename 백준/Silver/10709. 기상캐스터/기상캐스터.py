import sys

input = sys.stdin.readline

H, W = map(int, input().split())

cloud = [list(input().strip()) for _ in range(H)]
answer = []

for each in cloud:
    count = -1
    tmp = []
    for one in each:
        if one == 'c':
            count = 0
            tmp.append(0)
        elif one == '.':
            if count == -1:
                tmp.append(-1)
            else:
                count += 1
                tmp.append(count)
    answer.append(tmp)

for each in answer:
    print(*each)