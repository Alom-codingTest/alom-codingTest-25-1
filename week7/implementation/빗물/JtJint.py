import sys
input = sys.stdin.readline
from collections import deque

h, w = map(int, input().split(' '))
box = []

for i in range(h) :
    box.append(['0']*w)
    
a = list(map(int, input().split(' ')))    
    
for i in range(w) :
    for j in range(h-a[i], h) :
        box[j][i] = '*'
        


def fulling(left, right) :
    lefti, leftj = left.pop()
    righti,rightj = right.pop()
    if rightj - leftj <= 1 :
        return (righti,rightj)  
    for i in range(leftj+1, rightj) :
        if box[lefti][i] == '0' :
            box[lefti][i] = '-'
        
    return (righti,rightj)  
for i in range(h-1, -1, -1) :
    left = []
    right = []
    for j in range(w) :
        if box[i][j] == '*' :
            if len(left) == 0 :
                left.append([i,j])
            else :
                right.append([i,j])
                left.append(fulling(left, right))
                
cnt =0
for i in range(h) :
    for j in range(w) :
        # print(box[i][j],end='')
        if box[i][j] == '-':
            cnt+=1
    # print()

print(cnt)
        