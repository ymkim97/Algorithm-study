import sys

input = sys.stdin.readline

K = int(input())
visited = list(map(int, input().split()))

def recur(listToVisit):

    newList = []
    isExit = False

    for each in listToVisit:
        start, end = each[0], each[1]

        if start == end:
            print(visited[start], end=' ')
            isExit = True
            continue

        mid = (start + end) // 2
 
        print(visited[mid], end=' ')
        newList.append((start, mid - 1))
        newList.append((mid + 1, end))
    
    if isExit:
        return
    
    print()

    recur(newList)

recur([[0, (2 ** K) - 2]])