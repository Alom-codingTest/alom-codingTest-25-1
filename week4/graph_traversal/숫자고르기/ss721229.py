# 40m
import sys
input = sys.stdin.readline

def dfs(now, start):
    visited[now] = True
    item = nums[now]

    if not visited[item]:
        dfs(item, start)
    elif visited[item] and item == start:
        result.append(item)

N = int(input())
nums = [0] + [int(input()) for _ in range(N)]
result = []

for i in range(1, N + 1):
    visited = [False] * (N + 1)
    dfs(i, i)
print(len(result))
for i in sorted(result):
    print(i)