import sys

input = sys.stdin.readline

N = int(input())

letter = [input().strip() for _ in range(N)]

sortedLetter = sorted(list(enumerate(letter)), key=lambda x: x[1])

length = [0] * (N + 1)
maxLength = 0

def check(a, b):
    cnt = 0

    for i in range(min(len(a), len(b))):
        if a[i] == b[i]:
            cnt += 1
        else:
            break
    return cnt


for i in range(N - 1):
    tmp = check(sortedLetter[i][1], sortedLetter[i + 1][1])

    maxLength = max(maxLength, tmp)

    length[sortedLetter[i][0]] = max(length[sortedLetter[i][0]], tmp)
    length[sortedLetter[i + 1][0]] = max(length[sortedLetter[i + 1][0]], tmp)

first = 0

for i in range(N):
    if first == 0:
        if length[i] == max(length):
            first = letter[i]
            print(first)
            pre = letter[i][:maxLength]

    else:
        if length[i] == max(length) and letter[i][:maxLength] == pre:
            print(letter[i])
            break