import sys
input = sys.stdin.readline

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
edges = []
result, cnt = 0, 0

for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))
    result += c

edges.sort()

def find_parent(x):
    if x != parent[x]:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for c, a, b in edges:
    if find_parent(a) != find_parent(b):
        union_parent(a, b)
        result -= c

for i in range(1, N):
    if i == parent[i]:
        cnt += 1

if cnt > 1:
    print(-1)
else:
    print(result)