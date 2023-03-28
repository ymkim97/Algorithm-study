import sys

input = sys.stdin.readline

N, L = map(int, input().split())
water = [list(map(int, input().split())) for _ in range(N)]
water = sorted(water, key=lambda x: x[0])

cnt = 0
pointer = 0

for start, end in water:

    if pointer > start:
        start = pointer

    while start < end:
        start += L
        cnt += 1

    pointer = start

print(cnt)