import sys
input = sys.stdin.readline

def findCnt(l1, total):
    dp = [0] * (total + 1)
    dp[0] = 1 

    for coin in l1: 
        for j in range(coin, total + 1):
            dp[j] += dp[j - coin]

    return dp[total]

t = int(input())
for _ in range(t):
    n = int(input())
    l1 = list(map(int, input().split()))
    total = int(input())
    print(findCnt(l1, total))
