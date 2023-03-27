import sys

input = sys.stdin.readline

letter = list(input().strip())
bomb = input().strip()
answer = []

for each in letter:

    answer.append(each)

    if len(answer) >= len(bomb):
        tmp = ''.join(answer[len(answer) - len(bomb):])
        if tmp == bomb:
            for _ in range(len(bomb)):
                answer.pop()

print(*answer if len(answer) != 0 else "FRULA", sep='')