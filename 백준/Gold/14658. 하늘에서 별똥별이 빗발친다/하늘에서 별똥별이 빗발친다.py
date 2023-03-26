import sys

input = sys.stdin.readline

N, M, L, K = map(int, input().split())

meteor = [list(map(int, input().split())) for _ in range(K)]
maxReflex = 0

for i in range(K):
    for j in range(K):
        tramX = meteor[i][0]
        tramY = meteor[j][1]
        tmp = 0

        for each in meteor:
            if tramX <= each[0] <= tramX + L and tramY <= each[1] <= tramY + L:
                tmp += 1

        maxReflex = max(maxReflex, tmp)

print(K - maxReflex)