import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int, input().split())
mi=-1
result=[]

arr=[[]for _ in range (n+1)]
for i in range(m):
    a,b=map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)


def dfs(i):
    que=deque()
    que.append(i)
    num=1
    global mi
    global result
    visited=[0]*(n+1)
    visited[i]=1
    while que:
        a=que.popleft()
        for j in arr[a]:
            if visited[j]==0:
                que.append(j)
                num+=1
                visited[j]=1
    if num>mi:
        mi=num
    result.append(num)

for i in range(1, n+1):
    dfs(i)

result.sort()
print(mi)
print(result)
for i in range(n):
    if result[i]==mi:
        print(i+1, end=" ")
print()


