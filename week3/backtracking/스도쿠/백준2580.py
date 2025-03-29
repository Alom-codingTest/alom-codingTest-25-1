import sys
input = sys.stdin.readline

def solveSudoku(sudokuList, i, j):
    if j == 9:
        j = 0
        i += 1
    if i == 9:
        return True  # 성공적으로 끝났을 경우

    if sudokuList[i][j] != 0:
        return solveSudoku(sudokuList, i, j + 1)

    tmpList = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    tmpList = find3x3(sudokuList, i, j, tmpList)
    tmpList = findlinear(sudokuList, i, j, tmpList)

    for num in tmpList:
        sudokuList[i][j] = num
        if solveSudoku(sudokuList, i, j + 1):
            return True  # 정답을 찾았으면 바로 return

    sudokuList[i][j] = 0  # 백트래킹 (원상복구)
    return False

def find3x3(sudokuList, x, y, tmpList):
    tmpX = (x // 3) * 3
    tmpY = (y // 3) * 3
    box = [sudokuList[tmpX + i][tmpY + j] for i in range(3) for j in range(3)]
    return [num for num in tmpList if num not in box]

def findlinear(sudokuList, x, y, tmpList):
    deleteset = set(sudokuList[x])  # 가로 검사
    deleteset.update(sudokuList[j][y] for j in range(9))  # 세로 검사
    return [num for num in tmpList if num not in deleteset]

l1 = [list(map(int, input().strip().split())) for _ in range(9)]
solveSudoku(l1, 0, 0)

for row in l1:
    print(*row)
