# 1시간
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())

    l =[0] * (M + 1)
    l[0] = 1

    for j in range(1, N + 1):
        for k in range(1, M + 1):
            if k >= coins[j - 1]:
                l[k] += l[k-coins[j - 1]]
    print(l[M])