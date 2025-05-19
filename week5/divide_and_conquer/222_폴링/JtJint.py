import sys
input = sys.stdin.readline
from collections import deque

def poling222(n , tmpList) :
    yxList = [[0,0], [0,1], [1,0], [1,1]]
    rtList = []
    for i in range(0,n,2) :
        appendList = []
        for j in range (0,n,2) :
            tmp = []
            for y, x in yxList :
                tmp.append(tmpList[i+y][j+x])
            tmp.sort()
            tmp.reverse()
            appendList.append(tmp[1])
        rtList.append(appendList)
        
    return (n//2, rtList)
                        
n = int(input())
L = []
for i in range(n) :
    L.append(list(map(int, input().strip().split(" "))))
k = n
rtList = L

while k>1 :
    k, rtList = poling222(k,rtList)
    
print(rtList[0][0])