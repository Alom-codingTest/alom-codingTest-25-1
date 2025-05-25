import sys
t=int(sys.stdin.readline())
for i in range(t):
    n=int(sys.stdin.readline())
    coins=list(map(int,sys.stdin.readline().split()))
    m=int(sys.stdin.readline())
    arr=[0]*(m+1)
    arr[0]=1
    for i in coins:
        for j in range(i,m+1):
            arr[j]+=arr[j-i]
    print(arr[m])