import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
lst1 = []# 지뢰
# lst2 = []#주변 지뢰 갯수
openlst = []

fail = False
for _ in range(n) :
    k= input().strip()
    tmp = []
    for j in range(len(k)) :
        tmp.append(k[j])
    
    lst1.append(tmp)
for _ in range(n) :
    k= input().strip()
    tmp = []
    for j in range(len(k)) :
        tmp.append(k[j])
    
    openlst.append(tmp)

rtlst = []
def findCnt(i,j) :
    vector = [[-1,-1], [-1,0], [-1,1], [0,-1], [0,1], [1,-1], [1,0],[1,1]]
    cnt = 0
    for dy,dx in vector :
        y,x = i+dy, j+dx 
        if y < 0 or x < 0 or y >= n or x >=n :
            continue
        if lst1[y][x] == '*' :
            cnt+= 1
    return cnt

def faillst() :
    rt = []
    for i in range(n) :
        tmp = []
        for j in range(n) :
            tmp.append('*')
        rt.append(tmp)
    
    return rt
prtlst =[]
for i in range(n) :
    tmp = []
    for j in range(n) :
        if openlst[i][j] != 'x' :
            tmp.append('.')
            continue
        else :
            if lst1[i][j] == '*' :
                tmp.append('.')
                fail = True
            else :
                tmp.append(findCnt(i,j))

    prtlst.append(tmp)

if fail == True :
    for i in range(n) :
        for j in range(n) :
            if lst1[i][j] == '*' :
                prtlst[i][j] = '*'



for i in range(n) :
    for j in range(n) :
        print(prtlst[i][j], end='')
    print()