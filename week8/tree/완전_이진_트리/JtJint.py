import sys
input = sys.stdin.readline
from collections import deque
k = int(input())
#중위순회 출력을 트리로 만들기 문제
lst = list(map(int,input().split())) 
visited = [0 for i in range(len(lst))]
q = deque()
idx = len(lst)//2
q.append((0, idx, idx))
prevlevel = 0
while q :
    level, idx, val = q.popleft()
    visited[idx] = True
    if prevlevel != level :
        prevlevel = level
        print()
    print(lst[idx], end = ' ')
    for i in ((val//2+1)*-1, (val//2+1)) :
        if idx+i >=0 and idx+i < len(lst) and not visited[idx+i] :
            q.append((level+1, idx+i,val//2))
    