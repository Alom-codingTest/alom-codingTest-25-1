import sys
from collections import deque
input=sys.stdin.readline
n, m, v=map(int, input().split())
visited=[False]*(n+1)
edge=[[] for i in range(n+1)]
for i in range(m):
    a,b=map(int,input().split())
    edge[a].append(b)
    edge[b].append(a)
def DFS(v):
    if visited[v]==False:
        visited[v]=True
        print(v,end=" ")
        for j in edge[v]:
            if visited[j]==False:
                DFS(j)
def BFS(v):
    que=deque()
    que.append(v)
    while que:
        a=que.popleft()
        if visited[a]==False:
            visited[a]=True
            print(a,end=" ")
            for j in edge[a]:
                if visited[j]==False:
                    que.append(j)


for i in edge:
    i.sort()      
DFS(v)
print()
visited=[False]*(n+1)
BFS(v)