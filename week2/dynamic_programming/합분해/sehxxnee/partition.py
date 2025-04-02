#DP 문제-> 이전에 계산한 값을 저장해놓고 다시 계산하지 않도록 하는 기법
#       -> 점화식을 구해야 한다. 
#dp[k][n] = dp[k-1][0] + dp[k-1][1] + ... + dp[k-1][n] 


import sys

X = 1000000000

N,K = map(int,sys.stdin.readline().strip().split()) 
 
dp = [[0] * (N + 1) for _ in range(K + 1)]
 
for j in range(N + 1):
    dp[1][j] = 1
 
for i in range(2, K + 1):   
    for j in range(N + 1):   
        if j == 0:
            dp[i][j] = 1
        else:
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % X


print(dp[K][N])