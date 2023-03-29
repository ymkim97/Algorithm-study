from collections import defaultdict
import sys

input = sys.stdin.readline

N, C = map(int, input().split())

numbers = list(map(int, input().split()))

dic = defaultdict(int)

for each in numbers:
    dic[each] += 1

dic = sorted(dic.items(), key = lambda x: x[1], reverse=True)

for each in dic:
    for i in range(each[1]):
        print(each[0], end=' ')