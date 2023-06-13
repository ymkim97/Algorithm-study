from collections import deque

def solution(progresses, speeds):
    answer = []

    day = 0
    tmp = 0
    
    for i, each in enumerate(progresses): 
        if day * speeds[i] + each < 100:
            if tmp != 0:
                answer.append(tmp)
            tmp = 0
            daysToComplete = (100 - (day * speeds[i] + each)) // speeds[i]

            if each + (daysToComplete * speeds[i]) < 100:
                daysToComplete += 1

            day += daysToComplete
            tmp += 1
        else:
            tmp += 1
    
    if tmp != 0:
        answer.append(tmp)

    return answer
