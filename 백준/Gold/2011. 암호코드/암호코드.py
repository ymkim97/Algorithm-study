import sys

input = sys.stdin.readline

code = [0]
code += list(map(int, input().strip()))

if code[1] == 0:
    print(0)
    sys.exit(0)

length = len(code)
dp = [0] * length
dp[0] = dp[1] = 1

for i in range(2, length):
    first = code[i]
    ten = code[i - 1] * 10 + code[i]

    if first > 0:
        dp[i] += dp[i - 1]
    if 10 <= ten <= 26:
        dp[i] += dp[i - 2]

print(dp[length - 1] % 1000000)