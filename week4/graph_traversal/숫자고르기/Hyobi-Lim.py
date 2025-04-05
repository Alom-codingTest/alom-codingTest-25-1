import sys
n=int(sys.stdin.readline())
pick_numbers=dict()
for i in range(n):
    pick_numbers[i+1]=int(sys.stdin.readline())
answer=[]
for i in range(n):
    key=[i+1]
    value=[pick_numbers[i+1]]
    while(value[len(value)-1] not in key):
        key.append(value[len(value)-1])
        value.append(pick_numbers[key[len(key)-1]])
    if set(key)==set(value):
        for j in range(len(key)):
            if key[j] not in answer:
                answer.append(key[j])
answer.sort()
print(len(answer))
for i in answer:
    print(i)