from itertools import combinations

def solution(relation):
    answer = []
    comb = []
    
    for i in range(1, len(relation[0]) + 1):
        comb.extend(combinations(range(len(relation[0])), i))
    
    # print(comb)
    
    for i in comb:
        row = [tuple(each[a] for a in i) for each in relation]
        print(row)
        
        # 유일성 확인
        if len(set(row)) == len(relation):
            flag = True
            
            # 최소성 확인
            for j in answer:
                if set(j).issubset(set(i)):
                    flag = False
                    break

            if flag:
                answer.append(i)
    
    return len(answer)