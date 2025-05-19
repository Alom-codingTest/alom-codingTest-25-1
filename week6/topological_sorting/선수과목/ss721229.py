import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    arr[b][a] = 1

cnt = [1] * (N + 1)
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if arr[i][j] == 1:
            cnt[i] = max(cnt[j] + 1, cnt[i])
            
print(*cnt[1:])