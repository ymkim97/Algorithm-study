import sys
input = sys.stdin.readline

letter = input().rstrip()

countA = letter.count('a')
minimum = float('inf')

for i in range(len(letter)):
    countB = 0

    for j in range(countA):
        if letter[(i + j) % len(letter)] == 'b':
            countB += 1
    minimum = min(minimum, countB)

print(minimum)