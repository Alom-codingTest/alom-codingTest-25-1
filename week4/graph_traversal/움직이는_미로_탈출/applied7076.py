from collections import deque
dir = [(y, x) for y in range(-1, 2) for x in range(-1, 2)]
# print(dir)
board = [[None] * 8 for _ in range(8)]

for y in range(8):
    line = input()
    for x in range(8):
        board[y][x] = [-1] if line[x] == '.' else [0]

# 벽 떨어지기 기록
for y in range(8):
    for x in range(8):
        if board[y][x][0] == 0:  # 처음 벽을 찾아 쭉 내려주기
            now_y, now_x = y, x

            day = 1
            now_y += 1
            while now_y < 8:
                board[now_y][now_x].append(day)
                day += 1
                now_y += 1

# for y in range(8):
#    print(board[y])

queue = deque([(7, 0, 0)])  # y, x, day
while queue:
    now_y, now_x, now_day = queue.popleft()

    for dy, dx in dir:
        next_y = now_y + dy
        next_x = now_x + dx
        next_day = now_day + 1

        if next_y == 0 and next_x == 7:  # 도착
            print(1)
            exit(0)

        if 0 <= next_x < 8 and 0 <= next_y < 8:
            # 지금 벽으로도 못 가고, 다음 시간에 벽이 되어도 못 감
            if now_day not in board[next_y][next_x] and next_day not in board[next_y][next_x]:
                queue.append((next_y, next_x, next_day))

print(0)