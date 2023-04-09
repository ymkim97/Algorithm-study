import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input())
data = list(map(lambda x : int(x) if x.isdigit() else x, input().strip()))
answer = -float('inf')

def calculate(num1, num2, oper):
    if oper == '+':
        return num1 + num2
    elif oper == '-':
        return num1 - num2
    elif oper == '*':
        return num1 * num2
    
def dfs(idx, prev):

    global answer

    if idx >= N:
        answer = max(answer, prev)
        return

    if idx + 3 < N:
        dfs(idx + 4, calculate(prev, calculate(data[idx + 1], data[idx + 3], data[idx + 2]), data[idx]))

    dfs(idx + 2, calculate(prev, data[idx + 1], data[idx]))
    
if N == 1:
    answer = data[0]

else:
    dfs(1, data[0])

print(answer)