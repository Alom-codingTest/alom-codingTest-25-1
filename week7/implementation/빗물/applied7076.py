height, width = map(int, input().split())
board = [[''] * width for _ in range(height)]
cnt = 0

li = map(int, input().split())
for x, wall_h in enumerate(li):
    for y in range(-1, -1 - wall_h, -1):
        board[y][x] = 'W'

for y in range(height):
    for x in range(width):
        if not board[y][x]:
            left = None
            right = None

            find = x
            while find >= 0:
                if board[y][find]:
                    left = find
                    break
                find -= 1

            find = x
            while find < width:
                if board[y][find]:
                    right = find
                    break
                find += 1

            # print(y, x, left, right)
            if left is not None and right is not None:
                cnt += 1

print(cnt)