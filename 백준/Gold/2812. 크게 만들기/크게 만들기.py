N, K = map(int, input().split())

number = input()
stk = []
count = 0

for each in number:
    if len(stk) == 0:
        stk.append(each)
        continue

    if each > stk[-1]:
        while len(stk) != 0 and each > stk[-1] and count != K:
            stk.pop()
            count += 1
        
    stk.append(each)

while count != K:
    stk.pop()
    count += 1

print(''.join(stk))