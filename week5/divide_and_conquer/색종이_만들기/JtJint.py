def check_color(x, y, size):
    color = table[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if table[i][j] != color:
                return False
    return True

def makeColorPaper(listCnt, x, y, size):
    if check_color(x, y, size):
        listCnt[table[x][y]] += 1  
        return
    
    newSize = size // 2
    makeColorPaper(listCnt, x, y, newSize) 
    makeColorPaper(listCnt, x, y + newSize, newSize)
    makeColorPaper(listCnt, x + newSize, y, newSize)
    makeColorPaper(listCnt, x + newSize, y + newSize, newSize)

import sys
input = sys.stdin.readline

n = int(input())
table = [list(map(int, input().split())) for _ in range(n)]

listCnt = [0, 0] 

makeColorPaper(listCnt, 0, 0, n)

print(listCnt[0]) 
print(listCnt[1]) 
