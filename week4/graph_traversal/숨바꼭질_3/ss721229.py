# 1h 10m
import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    queue = deque([start])
    visited = [-1 for _ in range(100001)]
    visited[start] = 0

    if start == K:
        return 0

    while queue:
        item = queue.popleft()
        if item == K:
            return visited[item]
        for i in (2 * item, item - 1, item + 1):
            if 0 <= i < 100001 and visited[i] == -1:
                if i == 2 * item:
                    queue.append(i)
                    visited[i] = visited[item]
                else:
                    queue.append(i)
                    visited[i] = visited[item] + 1

N, K = map(int, input().split())
print(bfs(N))