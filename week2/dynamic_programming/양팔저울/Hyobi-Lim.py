import sys
n_weight=int(sys.stdin.readline())
weight=list(map(int,sys.stdin.readline().split()))
n_bead=int(sys.stdin.readline())
bead=list(map(int,sys.stdin.readline().split()))
weight_combination=set()
visited=set()
def weight_check(now_index,now_weight):
    if (now_index,now_weight) in visited:
        return
    weight_combination.add(now_weight)
    visited.add((now_index,now_weight))
    if now_index>=n_weight:
        weight_combination.add(now_weight)
        visited.add((now_index,now_weight))
        return
    else:
        weight_check(now_index+1,now_weight)
        weight_check(now_index+1,now_weight+weight[now_index])
        weight_check(now_index+1,now_weight-weight[now_index])
weight_check(0,0)
answer=[]
for i in bead:
    if i in weight_combination:
        answer.append('Y')
    else:
        answer.append('N')
print(*answer)