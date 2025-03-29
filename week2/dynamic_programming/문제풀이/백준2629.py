import sys
input = sys.stdin.readline

mapping = {}
n = int(input())
l1 = list(map(int, input().split(" ")))

def combination(n, tmpMap, total, dp,idx) :
    if n == 0 or idx >= len(tmpMap) :
        dp[total] += 1
        return total
    
    tmp = {}
    idxlist = []
    for i in tmpMap :
        tmp[i] = tmpMap[i]
        idxlist.append(i)
    for i in range(idx, len(tmp)) :
        if tmp[idxlist[i]] > 0 :
            tmp[idxlist[i]]-=1
            combination(n-1,tmp, total+idxlist[i],dp, i)
    

def dynamicP1(object, tmpMap, totalCnt) :
    
    tmpMap[object] = 1
    if object == 10 :
        a= 0
    n = 0
    #콘티 1 . object와 알고있는 것 (tmpMap)의 갯수 제한을 통한 조합으로 두개 이상의 조합이 나온다면
    #이는 내가 이녀석의 무게를 알 수 있다는 것을 방증
    for i in tmpMap :
        n += tmpMap[i]
    q= 0
    
    for i in tmpMap :
        q+= i*tmpMap[i]
    dp = [0]*(q+1)
    dp[0] = 1
    # 전체 갯수 파악 완료한 상태 이중에서 몇개만 뽑을지를 골라야함 ㅇㅈ? 그렇다면 1~n까지 조합을 짜야함.
    cnt = 1
    while cnt <= n :
        combination(cnt,tmpMap,0,dp,0)
        cnt+=1
    
    if 2 in dp :
        return True
    
    
    
    return False


for i in l1 :
    
    if i not in mapping :
        mapping[i] = 1
    else :
        mapping[i] +=1
k = int(input())
l2 = list(map(int, input().split(" ")))

result = []
for i in l2 :
    tmpMap = {}
    for keys in mapping :
        tmpMap[keys] = mapping[keys]
     #조합을 해야할 때 dp
    rt = dynamicP1(i, tmpMap, n)
    if rt == True :
        result.append('Y')
    else :
        result.append('N')
    
print(*result)