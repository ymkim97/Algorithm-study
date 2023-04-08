import sys

input = sys.stdin.readline

N = int(input())
kid = [int(input()) for _ in range(N)]
dp = [1] * N

for i in range(1, N):
    for j in range(i):
        if kid[i] > kid[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(N - max(dp))