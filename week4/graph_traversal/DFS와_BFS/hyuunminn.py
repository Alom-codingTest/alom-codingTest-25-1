import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m, start = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

for i in range(n + 1):
    graph[i].sort()


def DFS(v):
    visited_dfs[v] = True
    print(v, end = " ")
    for i in graph[v]:
        if not visited_dfs[i]:
            DFS(i)

DFS(start)

def BFS(v):
    visited_bfs[v] = True
    queue = deque()
    queue.append(v)

    while queue:
        curr = queue.popleft()
        print(curr, end = " ")
        for i in graph[curr]:
            if not visited_bfs[i]:
                queue.append(i)
                visited_bfs[i] = True

print()

BFS(start)

