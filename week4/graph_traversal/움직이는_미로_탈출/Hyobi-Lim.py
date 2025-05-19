import sys
sys.setrecursionlimit(10**6)
arr=[list(input().strip()) for _ in range(8)]
now=(7,0)
visited=set()
visited.add(now)
answer=0
def escape(now):
    global answer
    if answer==1:
        return
    if now[0]==0:
        answer=1
        return
    dx=[-1, -1, -1, 0, 1, 1, 1, 0, 0]
    dy=[-1, 0, 1, 1, 1, 0, -1, -1, 0]
    for i in range(len(dx)):
        if 0<=now[0]+dx[i]<=7 and 0<=now[1]+dy[i]<=7 and arr[now[0]+dx[i]][now[1]+dy[i]]=='.':
            if now[0]+dx[i]==0:
                answer=1
                break
            elif arr[now[0]+dx[i]-1][now[1]+dy[i]]=='.':
                if (now[0]+dx[i]-1,now[1]+dy[i]) not in visited:
                    visited.add((now[0]+dx[i]-1,now[1]+dy[i]))
                    escape([now[0]+dx[i]-1,now[1]+dy[i]])
escape(now)
print(answer)
