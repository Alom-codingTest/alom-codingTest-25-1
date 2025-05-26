k = int(input())
pre = list(map(int, input().split()))
res = [[] for _ in range(k)]

def pre2in(l, r, depth):
    if depth == k: 
        return
    if l == r:
        res[depth].append(pre[l])
        return
    
    center = (l + r) // 2
    res[depth].append(pre[center])
    pre2in(l, center - 1, depth + 1)
    pre2in(center + 1, r, depth + 1)

pre2in(0, len(pre), 0)

for lv in res:
    for item in lv:
        print(item, end=' ')
    print()