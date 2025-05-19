import sys
from copy import deepcopy
n,m=map(int,sys.stdin.readline().split())
arr=[list(map(int, input().split())) for _ in range(n)]
cctv=[]
for i in range(n):
    for j in range(m):
        if arr[i][j] in [1,2,3,4,5]:
            cctv.append([i,j])
answer=n*m
def check_left(arr,now):
    for i in range(now[1]-1,-1,-1):
        if arr[now[0]][i]==0:
            arr[now[0]][i]='#'
        elif arr[now[0]][i]==6:
            break
    return arr
def check_up(arr,now):
    for i in range(now[0]-1,-1,-1):
        if arr[i][now[1]]==0:
            arr[i][now[1]]='#'
        elif arr[i][now[1]]==6:
            break
    return arr
def check_right(arr,now):
    for k in range(now[1]+1,m):
        if arr[now[0]][k]==0:
            arr[now[0]][k]='#'
        elif arr[now[0]][k]==6:
            break
    return arr
def check_down(arr,now):
    for k in range(now[0]+1,n):
        if arr[k][now[1]]==0:
            arr[k][now[1]]='#'
        elif arr[k][now[1]]==6:
            break
    return arr
def blind_spot(arr,cctv):
    global answer
    if len(cctv)==0:
        cnt_cctv=0
        for i in range(n):
            #print(*arr[i])
            for j in range(m):
                if arr[i][j]==0:
                    cnt_cctv+=1
        #print('하나 끝',cnt_cctv)
        if answer>cnt_cctv:
            answer=cnt_cctv
        return
    now=cctv.pop()
    if arr[now[0]][now[1]]==1:
        now_arr=deepcopy(arr)
        now_arr=check_left(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_up(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_right(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_down(now_arr,now)
        blind_spot(now_arr,cctv)
        cctv.append(now)
    elif arr[now[0]][now[1]]==2:
        now_arr=deepcopy(arr)
        now_arr=check_left(now_arr,now)
        now_arr=check_right(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_up(now_arr,now)
        now_arr=check_down(now_arr,now)
        blind_spot(now_arr,cctv)
        cctv.append(now)
    elif arr[now[0]][now[1]]==3:
        now_arr=deepcopy(arr)
        now_arr=check_left(now_arr,now)
        now_arr=check_up(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_up(now_arr,now)
        now_arr=check_right(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_right(now_arr,now)
        now_arr=check_down(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_down(now_arr,now)
        now_arr=check_left(now_arr,now)
        blind_spot(now_arr,cctv)
        cctv.append(now)
    elif arr[now[0]][now[1]]==4:
        now_arr=deepcopy(arr)
        now_arr=check_left(now_arr,now)
        now_arr=check_up(now_arr,now)
        now_arr=check_right(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_up(now_arr,now)
        now_arr=check_right(now_arr,now)
        now_arr=check_down(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_right(now_arr,now)
        now_arr=check_down(now_arr,now)
        now_arr=check_left(now_arr,now)
        blind_spot(now_arr,cctv)
        now_arr=deepcopy(arr)
        now_arr=check_down(now_arr,now)
        now_arr=check_left(now_arr,now)
        now_arr=check_up(now_arr,now)
        blind_spot(now_arr,cctv)
        cctv.append(now)
    else:
        now_arr=deepcopy(arr)
        now_arr=check_left(now_arr,now)
        now_arr=check_up(now_arr,now)
        now_arr=check_right(now_arr,now)
        now_arr=check_down(now_arr,now)
        blind_spot(now_arr,cctv)
        cctv.append(now)
blind_spot(arr,cctv)
print(answer)