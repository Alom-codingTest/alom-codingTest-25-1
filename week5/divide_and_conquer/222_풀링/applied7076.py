import sys
from copy import deepcopy
sys.setrecursionlimit(int(1e6))

board = None

def get_next(p):
    y, x = p
    li = [board[y+i][x+j] for i in range(2) for j in range(2)]
    li.sort()
    return li[-2]


def process(l):
    global board

    if l == 1:
        return
    
    temp = [[0 for __ in range(l // 2)] for _ in range(l // 2)]
    for y in range(l // 2):
        for x in range(l // 2):
            temp[y][x] = get_next((y * 2, x * 2))

    board = deepcopy(temp)
    process(l // 2)


if __name__ == "__main__":
    n = int(input())
    board = []

    for i in range(n):
        board.append(list(map(int, input().split())))

    process(n)
    print(board[0][0])