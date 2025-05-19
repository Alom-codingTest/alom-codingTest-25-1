n = int(input())
mine = []
mines = []
board = []

for i in range(n):
    x = input().strip()
    mine.append([1 if p == '*' else 0 for p in x])

    for j in range(n):
        if mine[i][j]:
            mines.append((i, j))

for i in range(n):
    x = input().strip()
    board.append([p for p in x])

for i in range(n):
    for j in range(n):
        if board[i][j] == 'x':
            if (i, j) in mines:   # if mine opened
                for y, x in mines:
                    board[y][x] = '*'
                continue

            adj = []
            for dy in range(-1, 2):
                for dx in range(-1, 2):
                    if 0 <= i + dy < n and 0 <= j + dx < n:
                        adj.append(mine[i + dy][j + dx])

            board[i][j] = str(sum(adj))

for line in board:
    print(''.join(line))