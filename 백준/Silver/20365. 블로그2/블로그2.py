import sys

input = sys.stdin.readline

N = int(input())

problem = input().strip()

cri = problem[0]
count = 1

while problem:
    if problem[0] == cri:
        problem = problem.lstrip(cri)
        
    else:
        if cri == 'R':
            problem = problem.lstrip('B')
        else:
            problem = problem.lstrip('R')

        count += 1

print(count)