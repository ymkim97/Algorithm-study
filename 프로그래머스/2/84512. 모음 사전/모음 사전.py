def dfs(x, lst, vowel):
    lst.append(x)
    for i in vowel : 
        if len(x) != 5 :
            dfs(x + i, lst, vowel)
            
def solution(word):
    vowel = ['A','E','I','O','U']
    lst = []
    
    for i in range(len(vowel)) :
        dfs(vowel[i], lst, vowel)
    
    return lst.index(word) + 1