import sys

N = int(sys.stdin.readline())
square = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
white = 0
blue = 0


def cut(row, column, n):
    global white, blue
    color = square[row][column]
    for i in range(row, row + n):
        for j in range(column, column + n):
            if color != square[i][j]:
                cut(row, column, n // 2)  # 1사분면
                cut(row, column + n // 2, n // 2)  # 2사분면
                cut(row + n // 2, column, n // 2)  # 3사분면
                cut(row + n // 2, column + n // 2, n // 2)  # 4사분면
                return
    if color == 0:
        white += 1
    else:
        blue += 1


cut(0, 0, N)
print(white)
print(blue)
