import sys

input = sys.stdin.readline

N, M = map(int, input().split())

trees = list(map(int, input().split()))
start, end = 1, max(trees)

while start <= end:
    mid = (start + end) // 2

    log = 0

    for each in trees:
        if each > mid:
            log += each - mid
    
    if log >= M:
        start = mid + 1
    
    else:
        end = mid - 1

print(end)