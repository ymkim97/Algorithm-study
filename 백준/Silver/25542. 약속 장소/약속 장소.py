import sys

input = sys.stdin.readline

N, L = map(int, input().split())

def is_similar(checker, target):

    counter = 0

    for i in range(len(checker)):

        if checker[i] != target[i]:
            counter += 1

    if counter <= 1:
        return True
    
    return False


name_list = []
first_checker = True

for _ in range(N):
    eachName = list(input().strip())

    if first_checker:
        target_name = eachName
        first_checker = False

    else:
        name_list.append(eachName)

result_set = set()

for i in range(L):
    for alpha in range(65, 91):
        tmp = target_name[:]
        tmp[i] = chr(alpha)
        result_set.add(''.join(tmp))

while result_set and name_list:
    each = name_list.pop()
    remove_target = set()

    for each_result in result_set:
        if not is_similar(each, each_result):
            remove_target.add(each_result)
    
    for each_target in remove_target:
        result_set.remove(each_target)

if not result_set:
    print("CALL FRIEND")

else:
    print(result_set.pop())