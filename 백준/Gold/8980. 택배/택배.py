import sys
input = sys.stdin.readline

N, C = map(int, input().split())
M = int(input())
packages = [list(map(int, input().split())) for _ in range(M)]
packages = sorted(packages, key=lambda x: x[1])

answer = 0
village = [0] * (N + 1)

for start, end, weight in packages:
    tmp = weight

    for i in range(start, end):
        if village[i] + tmp > C:
            tmp = C - village[i]

    for i in range(start, end):
        village[i] += tmp

    answer += tmp

print(answer)