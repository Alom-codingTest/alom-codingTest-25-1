# 50m
import sys
from collections import deque
input = sys.stdin.readline

def bfs(num):
    queue = deque([num])
    visited = [0] * (N + 1)
    visited[num] = 1
    hacking_cnt = 1

    while queue:
        item = queue.popleft()
        for i in trust[item]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1
                hacking_cnt += 1
    return hacking_cnt


N, M = map(int, input().split())
trust = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    trust[B].append(A)

hacking_max_cnt = 0
result = []

for i in range(1, N + 1):
    cnt = bfs(i)
    if cnt > hacking_max_cnt:
        hacking_max_cnt = cnt
        result = []
        result.append(i)
    elif cnt == hacking_max_cnt:
        result.append(i)

print(*result)