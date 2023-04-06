import sys
from itertools import product

input = sys.stdin.readline

N = int(input())
K = int(input())

target = [list(map(int, input().split())) for _ in range(N)]
bullet = list(map(int, input().split()))
answer = 0
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
combi = list(product([a for a in range(N)], repeat=K))

for eachCombi in combi:
    tmpTarget = [arr[:] for arr in target]
    originalTargetScore = [arr[:] for arr in target]
    score = 0

    for i in range(len(eachCombi)):
        eachBullet = bullet[i]
        shootRange = eachCombi[i]

        for j in range(N):
            if tmpTarget[shootRange][j] != 0:
                if tmpTarget[shootRange][j] >= 10:
                    score += tmpTarget[shootRange][j]
                    tmpTarget[shootRange][j] = 0
                    originalTargetScore[shootRange][j] = 0

                elif eachBullet >= tmpTarget[shootRange][j]:
                    score += originalTargetScore[shootRange][j]
                    tmpTarget[shootRange][j] = 0

                    if originalTargetScore[shootRange][j] // 4 > 0:
                        # 네 방향으로 타겟 흩뿌리기
                        for k in range(4):
                            di = shootRange + d[k][0]
                            dj = j + d[k][1]

                            if 0 <= di < N and 0 <= dj < N and tmpTarget[di][dj] == 0:
                                tmpTarget[di][dj] = originalTargetScore[shootRange][j] // 4
                    
                        originalTargetScore = [arr[:] for arr in tmpTarget]

                    else:
                        originalTargetScore[shootRange][j] = 0

                elif eachBullet < tmpTarget[shootRange][j]:
                    tmpTarget[shootRange][j] -= eachBullet
                    
                break

    answer = max(answer, score)

print(answer)