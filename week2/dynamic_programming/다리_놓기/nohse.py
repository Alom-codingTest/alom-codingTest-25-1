import sys
import math
input=sys.stdin.readline

t=int(input())
for i in range(t):
  n, m=map(int,input().split())
  result=math.comb(m, n)
  print(result)
