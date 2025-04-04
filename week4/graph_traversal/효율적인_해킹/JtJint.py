import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)  # b->a 해킹 가능

def bfs(start):
    queue = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True
    count = 1  # 자기 자신도 포함

    while queue:
        node = queue.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = True
                queue.append(next_node)
                count += 1
    return count

maxCnt = 0
result = []
for i in range(1, n + 1):
    count = bfs(i)

    if count > maxCnt:
        max_hack = count
        result = [i]
    elif count == maxCnt:
        result.append(i)

print(*result)
