import sys
from collections import deque

def divide3(a) :
    if a%3 == 0:
        return a//3
    else :
        return None

def divide2(a) :
    if a%2 ==0 :
        return a//2
    else :
        return None
        
def minus1(a) :
    return a-1

n = int(input())

que = deque([n])
visited = set([n])
cnt =0
q = 0
if n == 1 :
    print(cnt)
    quit()

while que :
    cnt+=1
    for _ in range(len(que)) :
        current = que.popleft()
        value1 = divide3(current)
        value2 = divide2(current)
        value3 = minus1(current)
        for i in [value1, value2, value3] :
            if i is None or i in visited :
                continue
            if i == 1 :
                print(cnt)
                quit()
            
            que.append(i)
            visited.add(i)    
        
    
print(cnt)
        