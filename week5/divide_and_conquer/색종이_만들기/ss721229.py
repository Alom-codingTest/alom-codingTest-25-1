import sys
input = sys.stdin.readline

def recur(p, num):
    global cnt_blue, cnt_white
    w, b = 0, 0
    for i in p:
        for j in i:
            if j == 1:
                b = 1
            else:
                w = 1
        if b and w:
            break

    if w == 0:
        cnt_blue += 1
        return
    elif b == 0:
        cnt_white += 1
        return
    
    tmp_1 = p[:num//2]
    tmp_2 = p[:num//2]
    for i in range(num//2):
        tmp_1[i] = tmp_1[i][:num//2]
        tmp_2[i] = tmp_2[i][num//2:]
    recur(tmp_1, num//2)
    recur(tmp_2, num//2)

    tmp_1 = p[num//2:]
    tmp_2 = p[num//2:]
    for i in range(num//2):
        tmp_1[i] = tmp_1[i][:num//2]
        tmp_2[i] = tmp_2[i][num//2:]
    recur(tmp_1, num//2)
    recur(tmp_2, num//2)

N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
cnt_blue = 0
cnt_white = 0
recur(paper, N)
print(cnt_white)
print(cnt_blue)