import sys
input = sys.stdin.readline
from collections import deque
chess = deque()
visited = []
y,x = 7,0

for _ in range(8) :
    visited.append([0]*8)
    chess.append(input().strip())
    
changableX = [-1,0,1]
changalbeY = [-1,0,1]
Q = deque()
visited[7][0] = 1
Q.append((y,x, chess))

result = 0
while Q :
    posY, posX , c = Q.popleft()
    tmpChess = deque()
    for i in range(8) :
        tmpChess.append(c[i])
    # print(tmpChess)
    ableList = []
    flag = 0
    for i in range(8) :
        if tmpChess[i].count('#') == 0 :
            flag +=1
            
    if flag ==8 or posY == 0 and posX == 7 :
        result = 1
        break
    
    for i in changableX :
        for j in changalbeY :
            if (0<= posY+j <= 7 and 0<=posX+i<= 7)and tmpChess[posY+j][posX+i] == '.':
                # visited[posY+j][posX] = 1
                # Q.append((posY,posX,tmpChess))
                ableList.append((posY+j,posX+i))
    
    tmpChess.pop()
    tmpChess.appendleft('........')
    
    for i, j in ableList :
        if tmpChess[i][j] == '.' :
            Q.append((i,j,tmpChess))
            
print(result)