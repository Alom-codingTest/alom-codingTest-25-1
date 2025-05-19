from collections import deque
from sys import stdin

queue=deque()
N=int(stdin.readline())

for i in range(0,N):
    command = stdin.readline().strip().split()

    if command[0]=='push':
        queue.append(command[1])

    elif command[0]=='pop':
        if(len(queue)==0):
            print(-1)
        else:
            pop=queue.popleft()
            print(pop)

    elif command[0]=='size':
        size=len(queue)
        print(size)

    elif command[0]=='empty':
        if (len(queue)==0):
            print(1)
        else : 
            print(0)

    elif command[0]=='front':
        if(len(queue)==0):
            print(-1)
        else :
            print(queue[0])
    
    elif command[0]=='back':
        size=len(queue)
        if(size==0):
            print(-1)
        else:
            print(queue[size-1])