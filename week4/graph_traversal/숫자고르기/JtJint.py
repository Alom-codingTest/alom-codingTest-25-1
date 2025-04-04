import sys
input = sys.stdin.readline
from collections import deque
n = int(input())
array = [0]*(n+1)

for i in range(n) :
    array[i+1] = int(input())
    
result = []
set1 = set()
for i in range(1,n+1) :
    if array[i] == i :
        result.append(i)
    Q = deque()
    Q.append(i)
    tmp = []
    visited = [0]*(n+1)
    visited[i] = 1
    while Q :
        elem = Q.popleft()
        if array[elem] == i :
            for k in range(len(tmp)):
                result.append(tmp[k])
            break
        if visited[array[elem]] == 0 :
            visited[array[elem]] = 1
            tmp.append(array[elem])
            Q.append(array[elem])
            
            
result.sort()
for i in result :
    set1.add(i)
print(len(set1))
for i in set1 :
    print(i)