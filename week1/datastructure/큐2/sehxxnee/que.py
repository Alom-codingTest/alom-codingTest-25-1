import sys 
from collections import deque

N=int(sys.stdin.readline().strip())
#queue=[]와 같이 일반 리스트 선언하니 시간 초과
queue=deque()

for i in range(N):
    command=sys.stdin.readline().strip().split()
    if command[0] =="push":
        queue.append(int(command[1]))
        
    elif command[0]=="pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)

    elif command[0]=="size":
        print(len(queue))

    elif command[0]=="empty":
        if queue:
            print(0)
        else:
            print(1)

    elif command[0]=="front":
        if queue:
            print(queue[0])
        else:
            print(-1)

    elif command[0]=="back":
        if queue:
            print(queue[-1])
        else:
            print(-1)