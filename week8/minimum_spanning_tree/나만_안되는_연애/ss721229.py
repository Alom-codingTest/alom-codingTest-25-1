# 20m
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
l = input().rstrip().split()
parent = [[0, 0]] + [[i, j] for i, j in enumerate(l, start = 1)]
edges = []
result, cnt = 0, 0

for _ in range(M):
    u, v, d = map(int, input().split())
    edges.append((d, u, v))
edges.sort()

def find_parent(x):
    if x != parent[x][0]:
        parent[x][0] = find_parent(parent[x][0])
    return parent[x][0]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b][0] = a
    else:
        parent[a][0] = b

for d, u, v in edges:
    if find_parent(u) != find_parent(v):
        if parent[u][1] != parent[v][1]:
            union_parent(u, v)
            result += d

for i in range(1, N + 1):
    if i == parent[i][0]:
        cnt += 1

if cnt > 1:
    print(-1)
else:
    print(result)