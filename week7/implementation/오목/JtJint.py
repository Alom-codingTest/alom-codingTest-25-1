import sys
input = sys.stdin.readline
from collections import deque
lst = []
visited = []
result = 0
sty,stx =0,0
for i in range(19) :
    tmp = []
    for j in range(19):
        tmp.append([False,False,False,False])
    visited.append(tmp)
    lst.append(list(map(int, input().split(" "))))
    
def find(y,x) :
    rt = 0
    if y == 15 and x == 15 :
        print (2)
    if not visited[y][x][0] :
        rt += checkCol(y,x)
    if not visited [y][x][1] :
        rt += checkrow(y,x)
    if not visited[y][x][2] :
        rt += checkbot(y,x)
    if not visited[y][x][3] :
        rt += checktop(y,x)
        
    if rt != 0 :
        return lst[y][x]
    else :
        return 0
def checkCol(y,x) :
    checkCnt = 0
    for i in range(y,19) :
        if lst[i][x] == lst[y][x] :
            visited[i][x][0] = True
            checkCnt+=1
        else :
            break
    if checkCnt != 5 :
        return 0
    else :
        return 1
def checkrow(y,x) :
    checkCnt = 0
    for i in range(x,19) :
        if lst[y][i] == lst[y][x] :
            visited[y][i][1] = True
            checkCnt += 1
        else :
            break
    if checkCnt != 5 :
        return 0
    else :
        return 1    
def checkbot(y,x) :
    checkcnt = 0
    dy,dx = y,x
    
    while (0<=dy and dy <19) and (0<=dx and dx<19) :
        if lst[y][x] == lst[dy][dx] :
            visited[dy][dx][2] = True
            checkcnt+=1
        else :
            break
        dy += 1
        dx += 1
    if checkcnt != 5 :
        return 0
    else : 
        return 1
def checktop(y,x) :
    checkcnt = 0
    dy,dx = y,x
    while (0<=dy and dy <19) and (0<=dx and dx<19) :
        if lst[y][x] == lst[dy][dx] :
            visited[dy][dx][3] = True
            checkcnt+=1
        else :
            break
        dy -=1
        dx +=1
    if checkcnt != 5 :
        return 0
    else : 
        return 1    
for i in range(19) :
    for j in range(19) :
        if lst[j][i] == 1 or lst[j][i] == 2:
            result = find(j,i)
            sty,stx = j,i
            if result > 0 :
                break
                
    if result > 0 :
        break
if result == 0 :
    print(result)
else :
    print(result)
    print(sty+1,stx+1)

    
    
