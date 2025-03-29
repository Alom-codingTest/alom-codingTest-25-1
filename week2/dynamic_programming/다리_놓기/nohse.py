import sys,math
input=sys.stdin.readlinen
n=int(input())
result=0
a=n//2
for i in range(a+1):
    resutl=math.comb(n-i,i)
print(result%10007)