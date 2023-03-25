import sys
input = sys.stdin.readline
sys.setrecursionlimit(111111)

T = int(input())

def dfs(x):
    
    global ans

    visit[x] = True
    cycle.append(x)
    number = student[x]

    if visit[number]:
        if number in cycle:
            ans += cycle[cycle.index(number):]
        return
    
    else:
        dfs(number)

for _ in range(T):
    
    n = int(input())

    student = [0] + list(map(int, input().split()))
    visit = [False] * (n + 1)
    ans = []

    for i in range(1, n + 1):
        if not visit[i]:
            cycle = []
            dfs(i)

    print(n - len(ans))