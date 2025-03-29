# import sys, math
# input=sys.stdin.readline
# n=int(input())
# s=[]
# b=[]
# dp=[1e9]*n
# dp[0]=0
# for i in range(n-1):
#     a, c=map(int, input().split())
#     s.append(a)
#     b.append(c)
#     if i<n-1:
#         dp[i+1]=min(dp[i]+s[i],dp[i+1])
#     if i<n-2:
#         dp[i+2]=min(dp[i+2],dp[i]+b[i])
# max=-1
# maxindex=0
# for i in range(n-3):
#     mini=99999999
#     if(mini>s[i]+s[i+1]+s[i+2]):
#         mini=s[i]+s[i+1]+s[i+2]
#     if(mini>s[i]+b[i+1]):
#         mini=s[i]+b[i+1]
#     if(mini>b[i]+s[i+1]):
#         mini=b[i]+s[i+1]
#     if(max<mini):
#         max=mini
#         maxindex=i

# k=int(input())
# if k<max:
#     if(maxindex==n-4):
#         total=dp[maxindex]+k
#     else:
#         total=dp[maxindex]+k-dp[maxindex+2]+dp[n-1]

#     print(min(total,dp[n-1]))
# else :
#     print(dp[n-1])
import sys
input = sys.stdin.readline

N = int(input())
stone = []

# dp 배열 생성
dp = [1e9]*N
dp[0] = 0
for i in range(N-1):
    s, b = map(int, input().split())
    stone.append((s, b))
    if i+1<N : dp[i+1] = min(dp[i+1], dp[i]+s)
    if i+2<N : dp[i+2] = min(dp[i+2], dp[i]+b)

# 매우 큰 점프 적용해보며 최솟값 찾기
K = int(input())
_min = dp[-1]
for i in range(3, N):
    e, dp1, dp2 = dp[i-3]+K, 1e9, 1e9
    for j in range(i, N-1):
        if i+1<=N : dp1 = min(dp1, e+stone[j][0])
        if i+2<=N : dp2 = min(dp2, e+stone[j][1])
        e, dp1, dp2 = dp1, dp2, 1e9
    _min = min(_min, e)

print(_min)