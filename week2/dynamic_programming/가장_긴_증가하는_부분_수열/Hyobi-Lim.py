import sys
from itertools import combinations
n=int(sys.stdin.readline())
arr=list(map(int,sys.stdin.readline().split()))
dp=[1]*n
for i in range(1,n):
    for j in range(i):
        if arr[j]<arr[i] and dp[j]+1>dp[i]:
            dp[i]=dp[j]+1
print(max(dp))