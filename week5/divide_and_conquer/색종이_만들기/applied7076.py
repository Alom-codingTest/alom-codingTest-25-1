import sys
sys.setrecursionlimit(int(1e6))

r0 = 0
r1 = 0
board = None

def pdf(p, diff):
    return (p[0] + diff[0] - 1, p[1] + diff[1] - 1)

def check(p1, p2):
    global r0, r1

    total = 0
    l = p2[0] - p1[0] + 1
    # print(p1, p2, l)
    for y in range(p1[0], p2[0] + 1):
        for x in range(p1[1], p2[1] + 1):
            total += board[y][x]

    if total == l ** 2:
        r1 += 1
        return True
    
    elif total == 0:
        r0 += 1
        return True
    
    return False


def process(p1, p2):
    if check(p1, p2):
        return
    
    # divide & conquer
    l_now = p2[0] - p1[0] + 1  # (0, 0) (3, 3) -> 4
    l_next = l_now // 2  # 2

    process(p1, pdf(p1, (l_next, l_next)))
    process(pdf(p1, (1, l_next + 1)), pdf(p1, (l_next, l_now)))
    process(pdf(p1, (l_next + 1, 1)), pdf(p1, (l_now, l_next)))
    process(pdf(p1, (l_next + 1, l_next + 1)), p2)

if __name__ == "__main__":
    n = int(input())
    board = []

    for i in range(n):
        board.append(list(map(int, input().split())))

    process((0, 0), (n-1, n-1))
    print(r0, r1, sep='\n')