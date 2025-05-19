import sys
sys.setrecursionlimit(int(1e6))
board = [[' ' for _ in range(3**7 + 1)] for _ in range(3**7 + 1)]

def process(N, y, x):
    if N == 1:
        board[y][x] = '*'
        return
    
    for _y in range(3):
        for _x in range(3):
            if _y == 1 and _x == 1:
                continue
            process(N // 3, y + N // 3 * _y, x + N // 3 * _x)


if __name__ == "__main__":
    N = int(input())
    process(N, 0, 0)
    for y in range(N):
        print(''.join(board[y][:N]))