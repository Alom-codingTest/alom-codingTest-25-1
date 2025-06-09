import sys
input=sys.stdin.readline
n, m=map(int, input().split())
arr=list(range(1,n+1))
answer=[0]*m
def back(k):
    if k==m:
        for i in range(m):
            print(answer[i], end=' ')
        print()
        return
    for i in range(0, n):
        answer[k]=arr[i]
        back(k+1)

back(0)