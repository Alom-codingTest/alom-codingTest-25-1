import sys
input = sys.stdin.readline
from collections import deque
visited = [0]*100001
n, k = map(int, input().strip().split(" "))
Q = deque()

Q.append((n,0))
visited[n] = 1
results = []
while Q :
    n, time = Q.popleft()
    if n == k :
        results.append(time)

    if 2*n <= 100000:
        if visited[2*n] == 0 :
            visited[2*n] = 1
            Q.append((2*n,time)) 
    if n-1 >= 0 :
        if visited[n-1] == 0 :
            visited[n-1] = 1
            Q.append((n-1, time+1))        
    if n+1 <= 100000 :
        if visited[n+1] == 0 :
            visited[n+1] = 1
            Q.append((n+1, time+1))
        
print(min(results))