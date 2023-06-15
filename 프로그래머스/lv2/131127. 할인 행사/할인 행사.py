from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    cri = dict()
    
    for i, eachWant in enumerate(want):
        cri[eachWant] = number[i]
        
    for i in range(len(discount) - 9):
        tmpDict = defaultdict(int)

        for j in range(i, i + 10):
            tmpDict[discount[j]] += 1
    
        if tmpDict == cri:
            answer += 1
    
    return answer