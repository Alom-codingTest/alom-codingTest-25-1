import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=[0]*m
def back(arr, k):
    global m, n
    if k==m:
        for i in range(m):
            print(arr[i], end=" ")
        print()
        return

    for i in range(1, n+1):
        if k==0:
            arr[0]=i
            back(arr, k+1)
        else:
            if arr[k-1]<=i:
                arr[k]=i
                back(arr,k+1)
back(arr,0)