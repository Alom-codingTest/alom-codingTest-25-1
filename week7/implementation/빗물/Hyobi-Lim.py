import sys
h,w=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
answer=0
for i in range(1,w-1):
    left_max=0
    right_max=0
    for j in range(0,i):
        if left_max<arr[j]:
            left_max=arr[j]
    for j in range(i+1,w):
        if right_max<arr[j]:
            right_max=arr[j]
    if left_max>arr[i] and right_max>arr[i]:
        answer+=(min(left_max,right_max)-arr[i])
print(answer)