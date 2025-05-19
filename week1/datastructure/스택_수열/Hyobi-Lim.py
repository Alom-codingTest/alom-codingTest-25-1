import sys
n=int(sys.stdin.readline())
stack=[]
answer=[]
now=1
for i in range(n):
    num=int(sys.stdin.readline())
    if num>=now:
        for j in range(now,num+1):
            stack.append(j)
            now+=1
            answer.append('+')
        stack.pop()
        answer.append('-')
    elif num==stack[len(stack)-1]:
        stack.pop()
        answer.append('-')
    else:
        break
if len(answer)==2*n:
    for i in answer:
        print(i)
else:
    print("NO")