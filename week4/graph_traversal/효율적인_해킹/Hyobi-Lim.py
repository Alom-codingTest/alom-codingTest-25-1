from collections import deque
n,m=map(int,input().split())
computers={i:[] for i in range(1,n+1)}
for i in range(m):
    a,b=map(int,input().split())
    computers[b].append(a)
answer=[]
max_hacking_computers=0
for i in range(1,n+1):
    queue=deque([i])
    visited=[0]*(n+1)
    visited[i]=1
    while(queue):
        now=queue.popleft()
        for j in computers[now]:
            if visited[j]==0:
                visited[j]=1
                queue.append(j)
    num=sum(visited)
    if num>max_hacking_computers:
        max_hacking_computers=num
        answer=[i]
    elif num==max_hacking_computers:
        answer.append(i)
for i in answer:
  print(i, end=' ')
