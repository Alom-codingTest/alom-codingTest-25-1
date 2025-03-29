import math

n = int(input())
arr = []
flag = 0

for _ in range(n - 1):
    small, big = map(int, input().split())
    arr.append((small, big))
k = int(input())

dp = [[math.inf] * 2 for _ in range(n)]

dp[0][0] = 0
dp[0][1] = 0
for i in range(1, n):
    dp[i][0] = min(dp[i][0], dp[i - 1][0] + arr[i - 1][0])
    dp[i][1] = min(dp[i][1], dp[i - 1][1] + arr[i - 1][0])

    if i - 1 > 0:
        dp[i][0] = min(dp[i][0], dp[i - 2][0] + arr[i - 2][1])
        dp[i][1] = min(dp[i][1], dp[i - 2][1] + arr[i - 2][1])

    if i - 2 > 0:
        dp[i][1] = min(dp[i][1], dp[i - 3][0] + k)


print(min(dp[n - 1]))
