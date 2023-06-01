import sys

input = sys.stdin.readline

student = [list(input().strip()) for _ in range(5)]
d = [(1, 0), (-1, 0), (0, 1), (0, -1)]
answer = 0
comb = set()

def backtrack(S, Y):
    global answer
    global tmp

    if Y > 3:
        return

    if len(tmp) == 7:
        if S >= 4:
            tupleTmp = tuple(sorted(tmp))
            if tupleTmp not in comb:
                comb.add(tupleTmp)
                answer += 1

        return

    for each in tmp:
        x = each // 5
        y = each % 5

        for i in range(4):
            dx = x + d[i][0]
            dy = y + d[i][1]
            n = dx * 5 + dy

            if 0 <= dx < 5 and 0 <= dy < 5 and n not in tmp:
                tmp.append(n)
                if student[dx][dy] == 'Y':
                    backtrack(S, Y + 1)
                else:
                    backtrack(S + 1, Y)
                tmp.pop()

for i in range(5):
    for j in range(5):
        if student[i][j] == 'S':
            tmp = []
            tmp.append(i * 5 + j)
            backtrack(1, 0)

print(answer)