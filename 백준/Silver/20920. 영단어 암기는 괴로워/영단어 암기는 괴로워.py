import sys

input = sys.stdin.readline

N, M = map(int, input().split())
wordList = dict()

for _ in range(N):
    word = input().rstrip()

    if len(word) < M:
        continue

    if wordList.get(word):
        wordList[word][0] += 1
    else:
        wordList[word] = [1, len(word), word]
    
ans = sorted(wordList.items(), key = lambda x: (-x[1][0], -x[1][1], x[1][2]))

for each in ans:
    print(each[0])