import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
broken = list(map(int, input().split()))
ans = abs(100 - N)

for num in range(1000001):
    num = str(num)

    for j in range(len(num)):
        if int(num[j]) in broken:
            break

        elif j == len(num) - 1:
            ans = min(ans, len(num) + abs(int(num) - N)) 

print(ans)