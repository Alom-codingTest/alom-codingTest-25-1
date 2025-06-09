import sys
from collections import deque

input=sys.stdin.readline
n=int(input())
arr=[]
visited=[[0] *(n) for _ in range(n)]
result = [0] * (n * n + 1)
num=0
for i in range(n):
    row=list(map(int, input().strip()))
    arr.append(row)
que=deque()
def dfs(k, l):
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    global num
    global visited
    global arr
    global que
    num+=1
    que.append((k, l))
    visited[k][l]=1
    result[num]+=1
    while que:
        x,y= que.popleft()
        for v in range(4):
            nx, ny = x + dx[v], y + dy[v]
            if 0 <= nx < n and 0 <= ny < n:
                if arr[nx][ny] == 1 and visited[nx][ny] == 0:
                    que.append((nx, ny))
                    visited[nx][ny] = 1
                    result[num] += 1


for k in range(0, n):
    for l in range(0, n):
        if visited[k][l]==0 and arr[k][l]==1:
            dfs(k, l)

print(num)
result.sort()
for j in result:
    if j==0:
        continue
    print(j)