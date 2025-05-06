from collections import deque
import sys

input = sys.stdin.readline

def bfs(start):
    visited = [False] * (n + 1)
    q = deque()
    q.append(start)
    path = [start]
    visited[start] = True

    while q:
        current = q.popleft()
        next_node = data[current]

        if not visited[next_node]:
            visited[next_node] = True
            q.append(next_node)
            path.append(next_node)
        elif next_node == start:
            result.extend(path)
            return

n = int(input())
data = [0] + [int(input()) for _ in range(n)]
result = []

for i in range(1, n + 1):
    if i not in result:  # 이미 포함된 숫자는 생략
        bfs(i)

result = sorted(set(result))
print(len(result))
for num in result:
    print(num)
