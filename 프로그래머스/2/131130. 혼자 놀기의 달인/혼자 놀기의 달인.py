def solution(cards):
    answer = []
    
    for i in range(len(cards)):
        tmp = []
        
        while cards[i] not in tmp:
            tmp.append(cards[i])
            i = cards[i] - 1
            
        if sorted(tmp) not in answer:
            answer.append(sorted(tmp))
            
        answer = sorted(answer, key=lambda x: -len(x))

    if len(answer) == 1:
        return 0
    
    return len(answer[0]) * len(answer[1])