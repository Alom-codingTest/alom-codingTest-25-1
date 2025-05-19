import sys
input = sys.stdin.readline
from collections import deque

def star3(n) :
    lst = []
    for i in range (n) :
        lst.append(['*']*n)

    k = n//3
    cnt = 1
    while k!= 0 :
        for i in range(k,n,3*k):
            for j in range(k,n,3*k) :
                for l in range(i,i+k) :
                    for m in range(j,j+k) :
                        lst[l][m] = ' '     
        
        k= k//3
        
    for i in range(n) :
        for j in range(n) :
            print(lst[i][j], end='')
        print()
n = int(input())

k = 1

star3(n)