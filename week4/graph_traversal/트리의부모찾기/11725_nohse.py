import sys
from collections import deque

input = sys.stdin.readline
n = int(input())

# 인접 리스트로 초기화
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs():
    que = deque()
    que.append(1)
    while que:
        a = que.popleft()
        for i in graph[a]:
            if result[i] == 0:
                result[i] = a
                que.append(i)

result = [0] * (n + 1)
result[1] = 1  # 시작 노드의 부모를 자기 자신으로 표시
bfs()

for j in range(2, n + 1):
    print(result[j])
