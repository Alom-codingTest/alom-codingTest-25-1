n = int(input().strip())
dp = [False] * (n + 1)

# i개 돌있을경우 참
for i in range(1, n + 1):
    # 1개를 가져갈 수 있는 경우
    if i - 1 >= 0 and not dp[i - 1]:
        dp[i] = True
    # 3개를 가져갈 수 있는 경우
    elif i - 3 >= 0 and not dp[i - 3]:
        dp[i] = True


print("SK" if dp[n] else "CY")
