import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split(' '))
space = []
visited =[]
y, x = 0,0 
point = deque()
for i in range(n) :
    visited.append([False]*m)
    space.append(list(map(int, input().split(' '))))
    
    for j in range(m) :
        if space[i][j] == 9 :
            point.append((i,j))
            visited[i][j] = True

cnt = len(point)
def findCnt(y,x) :
    rt = 0
    visited[y][x] = True
    for vector in range(1, 5) :
        dy, dx = y,x
        while True :
            if vector == 1 :
                dx -=1
                if dx < 0 :
                    break
            elif vector == 2 :
                dx += 1
                if dx >= m :
                    break
            elif vector == 3 :
                dy -= 1 
                if dy < 0 :
                    break
            elif vector == 4 :
                dy += 1
                if dy >= n :
                    break
            if visited[dy][dx] == False :
                visited[dy][dx] = True
                rt +=1 
            if space[dy][dx] == 1 :
                if vector == 1 or vector == 2 :
                    break
            elif space[dy][dx] == 2 :
                if vector == 3 or vector == 4 :
                    break
            elif space[dy][dx] == 3 :
                if vector == 1 :
                    vector =4
                elif vector == 2 :
                    vector = 3
                elif vector == 3 :
                    vector = 2
                elif vector == 4 :
                    vector = 1
            elif space[dy][dx] == 4 :
                if vector == 1 :
                    vector = 3
                elif vector == 2 :
                    vector = 4
                elif vector == 3 :
                    vector = 1
                elif vector == 4 :
                    vector = 2
    return rt
    
while point :
    y,x = point.popleft()
    cnt += findCnt(y,x)


print(cnt)