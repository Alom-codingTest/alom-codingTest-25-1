import sys
input = sys.stdin.readline

cnt = 0
n = int(input())
m = int(input())
arr = [[] for _ in range(n + 1)]
visted = [False] * (n + 1)
for i in range(m):
    start, end = map(int, input().split())
    arr[start].append(end)
    arr[end].append(start)

def dfs(v):
    global cnt
    visted[v] = True

    for i in arr[v]:
        if not visted[i]:
            dfs(i)
            cnt += 1
    

dfs(1)
print(cnt)
