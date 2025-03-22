# 40분
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
l = [1] * N

for i in range(1, N):
    for j in range(i):
        if A[i] > A[j]:
            l[i] = max(l[i], l[j] + 1)

print(max(l))