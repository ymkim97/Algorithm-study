from collections import deque
import sys

input = sys.stdin.readline

T = int(input())

def dfs(x):

    if x == N:
        total = 0
        operation = '+'
        cpy = deque(tmp[:])
        
        while cpy:
            number = ''

            if cpy[0] == '+' or cpy[0] == '-':
                operation = cpy.popleft()

            while cpy[0] != '+' and cpy[0] != '-':
                if cpy[0] == ' ':
                    cpy.popleft()

                number += cpy.popleft()
                if len(cpy) == 0:
                    break

            if operation == '+':
                total += int(number)
            elif operation == '-':
                total -= int(number)
             
        if total == 0:
            print(*tmp,sep='')

        return
    
    for i in range(3):
        if i == 0:
            tmp.append(' ')
            
            
        elif i == 1:
            tmp.append('+')
            
        else:
            tmp.append('-')

        tmp.append(str(x + 1))
        dfs(x + 1)
        tmp.pop()
        tmp.pop()

for _ in range(T):
    N = int(input())
    tmp = ['1']

    dfs(1)
    print()
