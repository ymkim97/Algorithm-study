def solution(clothes):
    answer = 1

    clothesType = dict()

    for each in clothes:
        if each[1] not in clothesType:
            clothesType[each[1]] = 1
        else:
            clothesType[each[1]] += 1

    
    for val in clothesType.values():
        answer *= (val + 1)

    answer -= 1
    
    return answer