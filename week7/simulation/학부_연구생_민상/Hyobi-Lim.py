import sys
sys.setrecursionlimit(10**6)
n,m=map(int,sys.stdin.readline().split())
arr=[list(map(int, input().split())) for _ in range(n)]
visited=[[0]*m for _ in range(n)]
def cool_place(i,j,direction):
    while True:
        i+=direction[0]
        j+=direction[1]
        if i<0 or i>=n or j<0 or j>=m:
            break
        if not visited[i][j]:
            visited[i][j]=1
        if arr[i][j]==9:
            break
        elif arr[i][j]==1:
            if direction[0]==0:
                break
        elif arr[i][j]==2:
            if direction[1]==0:
                break
        elif arr[i][j]==3:
            if direction==(1,0):
                direction=(0,-1)
            elif direction==(0,1):
                direction=(-1,0)
            elif direction==(0,-1):
                direction=(1,0)
            elif direction==(-1,0):
                direction=(0,1)
        elif arr[i][j]==4:
            if direction==(0,-1):
                direction=(-1,0)
            elif direction==(1,0):
                direction=(0,1)
            elif direction==(-1,0):
                direction=(0,-1)
            elif direction==(0,1):
                direction=(1,0)
    return
for i in range(n):
    for j in range(m):
        if arr[i][j] == 9:
            visited[i][j] = 1
            cool_place(i,j,(0,-1))
            cool_place(i,j,(-1,0))
            cool_place(i,j,(0,1))
            cool_place(i,j,(1,0))
answer=0
for i in range(n):
    for j in range(m):
        if visited[i][j]==1:
            answer+=1
print(answer)