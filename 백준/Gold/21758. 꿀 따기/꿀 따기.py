import sys

input = sys.stdin.readline

N = int(input())

honey = list(map(int, input().split()))
S = [honey[0]]
ans = 0

for i in range(1, N):
    S.append(honey[i] + S[-1])

# 벌통이 맨 오른쪽
for i in range(1, N - 1):
    ans = max(ans, S[-1] - S[0] - honey[i]+ S[-1] - S[i])

# 벌통이 맨 왼쪽
for i in range(1, N - 1):
    ans = max(ans, S[-1] - honey[-1] - honey[i]+ S[i - 1])

# 벌통이 가운데
for i in range(1, N - 1):
    ans = max(ans, S[i] - S[0] + S[-1] - S[i - 1] - honey[-1])

print(ans)