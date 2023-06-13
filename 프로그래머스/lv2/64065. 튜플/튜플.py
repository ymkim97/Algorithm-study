def solution(s):
    answer = []
    
    tupl = []
    tmpCh = []
    tmpNum = []
    
    for ch in s:
        if ch.isdigit():
            tmpCh.append(ch)
            continue
        
        if len(tmpCh) != 0:
            tmpNum.append(int(('').join(tmpCh[:])))
            tmpCh.clear()
            
        if ch == '}' and len(tmpNum) != 0:
            tupl.append(tmpNum[:])
            tmpNum.clear()
        
    tupl = sorted(tupl, key=lambda x: len(x))
    
    for eachGroup in tupl:
        for num in eachGroup:
            if num not in answer:
                answer.append(num)
                continue;
        
    return answer