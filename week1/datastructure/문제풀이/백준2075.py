import sys
input = sys.stdin.readline

n = int(input())

l1 = []
for _ in range(n) :
    l2 = list(map(int, input().split(" ")))
    if len(l1) == 0:
        for i in range(len(l2)) :
            l1.append(l2[i])
        l1.sort()
    else :
        l2.sort()
        l2.reverse()
        for i in range(len(l2)) :
            if l2[i] > l1[i] :
                l1[i] = l2[i]
        l1.sort()
        
print(l1[0])
    
