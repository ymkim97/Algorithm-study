def solution(data, col, row_begin, row_end):
    answer = 0
    
    data.sort(key=lambda x: (x[col - 1], -x[0]))
    
    for i in range(row_begin, row_end + 1):
        dataSum = 0
        
        for num in data[i - 1]:
            dataSum += num % i
        
        answer ^= dataSum
        
    
    return answer