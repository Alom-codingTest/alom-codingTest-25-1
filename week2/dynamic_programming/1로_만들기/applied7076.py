MAX = 10000001
n = int(input())

dp = [MAX] * (n+1)

dp[1] = 0

for i in range(2, n+1):
    dp[i] = min(dp[i], dp[i-1] + 1)
    dp[i] = min(dp[i], dp[i//2] + 1) if i % 2 == 0 else dp[i]
    dp[i] = min(dp[i], dp[i//3] + 1) if i % 3 == 0 else dp[i]

print(dp[n])