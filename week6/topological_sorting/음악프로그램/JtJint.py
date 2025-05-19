import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())  
graph = [[] for _ in range(n + 1)] 
indegree = [0] * (n + 1)  

for _ in range(m):
    lst = list(map(int, input().split()))
    for i in range(1, lst[0]):
        a = lst[i]
        b = lst[i + 1]
        graph[a].append(b)
        indegree[b] += 1

q = deque()
result = []

for i in range(1, n + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    result.append(cur)

    for next in graph[cur]:
        indegree[next] -= 1
        if indegree[next] == 0:
            q.append(next)

if len(result) == n:
    for x in result:
        print(x)
else:
    print(0) 
