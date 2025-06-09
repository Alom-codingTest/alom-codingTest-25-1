import sys
input=sys.stdin.readline
n=int(input())
arr=[]
for i in range(n):
    row=[]
    row=list(map(int, input().split()))
    arr.append(row)
white=0
blue=0
def divide(i, j, n):
    global white, blue
    flag=0
    check=arr[i][j]
    for k in range(n):
        for l in range(n):
            if check!=arr[i+k][j+l]:
                flag=1
                break
        if flag==1:
            break
    if flag==0 and check==0:
        white+=1
    elif flag==0 and check==1:
        blue+=1
    else:
        divide(i,j,n//2)
        divide(i+n//2, j, n//2)
        divide(i,j+n//2, n//2)
        divide(i+n//2, j+n//2, n//2)
divide(0, 0, n)
print(white)
print(blue)