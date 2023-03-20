import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

parents = [i for i in range(N + 1)]

def find(a):
    if a != parents[a]:
        parents[a] = find(parents[a])

    return parents[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a > b:
        parents[a] = b
    else:
        parents[b] = a

for i in range(1, N + 1):
    route = list(map(int, input().split()))
    for j in range(1, N + 1):
        if route[j - 1] == 1:
            union(i, j)

path = list(map(int, input().split()))

result = []

for each in path:
    result.append(find(each))

if len(set(result)) == 1:
    print("YES")
else:
    print("NO")