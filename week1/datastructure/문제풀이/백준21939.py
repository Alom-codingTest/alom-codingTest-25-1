import sys
input = sys.stdin.readline

n = int(input())
result = []
l1 = [0]*101
lList = []
mapping = {
    
}
for i in range(n) :
    pn , l = map(int, input().split(" "))
    if l1[l] == 0 :
        l1[l] = [pn]
        lList.append(l)
    else :
        l1[l].append(pn)
    mapping[pn]= l
        

m = int(input())
for i in range(m):
    orderList = list(input().strip().split(" "))
    pn = int(orderList[1])
    if len(orderList) == 3 :
        l = int(orderList[2]) 
        if l1[l] == 0 :
            l1[l] = [pn]
            lList.append(l)
        else :
            l1[l].append(pn)
        mapping[pn]= l
    else :
        lList.sort()
        
        if orderList[0] == 'recommend' :
            if pn == 1 :
                l1[lList[-1]].sort()
                result.append(l1[lList[-1]][-1])
            elif pn == -1 :
                l1[lList[0]].sort()
                result.append(l1[lList[0]][0])
                
        if orderList[0] == 'solved' :
            l1[mapping[pn]].remove(pn)
            if len(l1[mapping[pn]]) == 0 :
                l1[mapping[pn]] = 0
                lList.remove(mapping[pn])

for i in result :
    print(i)