import sys
input = sys.stdin.readline
N, r , c = map(int, input().strip().split(" "))


def meetMap(N,r,c) :
    left = 0
    top = 0
    right = 2**N-1
    bottom = 2**N-1
    rt = 0
    
    while N>=1 :
        midI = (top+bottom)//2
        midJ = (left+right)//2
        if (left <= c and c<= midJ) and top<= r and r<=midI :
            right = midJ
            bottom = midI
            rt += ((2**(N-1))**2)*0
        if midJ< c and c <=right and top<= r and r<= midI :
            left = midJ
            bottom = midI
            rt += ((2**(N-1))**2)*1#4
        if (left <= c and c<= midJ) and midI < r and r <=bottom :
            right = midJ
            top = midI
            rt += ((2**(N-1))**2)*2
        if midJ< c and c<= right and midI<r and r<=bottom :
            left = midJ
            top = midI
            rt += ((2**(N-1))**2)*3
        
        N-=1
    
    return rt

k = meetMap(N,r,c)
print(k)