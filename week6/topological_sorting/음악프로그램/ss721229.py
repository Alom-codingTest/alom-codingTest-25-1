import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)

for _ in range(M):
    arr = list(map(int, input().split()))
    for i in range(1, arr[0]):
        graph[arr[i]].append(arr[i + 1])
        indegree[arr[i + 1]] += 1

q, ans = [], []
for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    n = q.pop()
    ans.append(n)
    for i in graph[n]:
        indegree[i] -= 1

        if indegree[i] == 0:
            q.append(i)

if len(ans) != N:
    print(0)
else:
    for i in ans:
        print(i)