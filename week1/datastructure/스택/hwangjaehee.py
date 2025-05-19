import sys
from collections import deque

stack = deque()
N=int(sys.stdin.readline())

for i in range(0,N):
    command = sys.stdin.readline().strip().split()

    if command[0]=='push':
        stack.append(command[1])

    elif command[0]=='pop':
        if(len(stack)==0):
            print(-1)
        else:
            p=stack.pop()
            print(p)

    elif command[0]=='size':
        size=len(stack)
        print(size)

    elif command[0]=='empty':
        if (len(stack)==0):
            print(1)
        else : 
            print(0)
            
    elif command[0]=='top':
        l=len(stack)
        if (l==0):
            print(-1)
        else:
            print(stack[l-1])