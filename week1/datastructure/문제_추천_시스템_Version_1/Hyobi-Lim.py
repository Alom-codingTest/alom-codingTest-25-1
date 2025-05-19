import sys
lp=dict()
pl=dict()
n=int(sys.stdin.readline())
for i in range(n):
    p,l=map(int,sys.stdin.readline().split())
    if l not in lp:
        lp[l]=[]
    lp[l].append(p)
    if p not in pl:
        pl[p]=[]
    pl[p].append(l)
n=int(sys.stdin.readline())
for i in range(n):
    arr=list(sys.stdin.readline().split())
    arr[1]=int(arr[1])
    if arr[0]=='recommend':
        if arr[1]==1:
            print(max(lp[max(lp)]))
        else:
            print(min(lp[min(lp)]))
    elif arr[0]=='add':
        arr[2]=int(arr[2])
        if arr[2] not in lp:
            lp[arr[2]]=[]
        lp[arr[2]].append(arr[1])
        if arr[1] not in pl:
            pl[arr[1]]=[]
        pl[arr[1]].append(arr[2])
    else:
        for j in pl[arr[1]]:
            lp[j].remove(arr[1])
            if len(lp[j])==0:
                del lp[j]
        del pl[arr[1]]