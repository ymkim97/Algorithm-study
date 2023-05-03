import sys

input = sys.stdin.readline

N, M = map(int, input().split())
student = [[0] * (N + 1) for _ in range(N + 1)]

result = 0

for _ in range(M):
    a, b = map(int, input().split())
    student[a][b] = 1

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if student[i][j] == 0:
                if student[i][k] == 1 and student[k][j] == 1:
                    student[i][j] = 1

for i in range(1, N + 1):
    sum = 0
    for j in range(1, N + 1):
        sum += student[i][j] + student[j][i]

    if sum == N - 1:
        result += 1

print(result)