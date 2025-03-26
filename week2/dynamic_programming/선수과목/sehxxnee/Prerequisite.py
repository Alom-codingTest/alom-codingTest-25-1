import sys 
from collections import deque

# n이 과목의 수고 m이 선수 조건의 수
N,M=map(int,sys.stdin.readline().strip().split())
table=[[] for _ in range(N+1)]
res= [0]*(N+1)
pre = [0]* (N+1)

 

for _ in range (M):
    #A가 B의 선수과목
    A,B=map(int,sys.stdin.readline().strip().split())
    table[A].append(B)
    pre[B]+=1

queue=deque()
for i in range(1, N+1):
    if pre[i]==0:
        queue.append([i,1])

while queue:
    node, cnt=queue.popleft()
    res[node]=cnt
    for i in table[node]:
        pre[i]-=1
        if pre[i]==0:
            queue.append([i, cnt+1])

print(*res[1:])
