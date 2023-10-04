def solution(s):
    answer = len(s)
    
    for i in range(1, len(s) // 2 + 1):
        tmp = ''
        cnt = 1
        token = s[:i]
        
        for j in range(i, len(s), i):
            if token == s[j:i + j]:
                cnt += 1
            else:
                if cnt != 1:
                    tmp += str(cnt) + token
                else:
                    tmp += token
                token = s[j:j + i]
                cnt = 1
        if cnt != 1:
            tmp += str(cnt) + token
        else:
            tmp += token
            
        answer = min(answer, len(tmp))
    
    return answer