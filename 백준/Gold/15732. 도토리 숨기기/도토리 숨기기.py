import sys

input = sys.stdin.readline

N, K, D = map(int, input().split())

rules = [list(map(int, input().split())) for _ in range(K)]

left = 1
right = N

while left <= right:
    mid = (left + right) // 2

    cnt = 0
    for start, end, step in rules:
        if start > mid:
            continue

        if mid > end:
            cnt += (end - start) // step + 1

        else:
            cnt += (mid - start) // step + 1

    if cnt >= D:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)    