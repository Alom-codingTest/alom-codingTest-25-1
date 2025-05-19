import sys
n=int(sys.stdin.readline())
arr=[]
for i in range(n):
    arr+=list(map(int,sys.stdin.readline().split()))
    arr.sort(reverse=True)
    arr=arr[:n]
print(arr[n-1])