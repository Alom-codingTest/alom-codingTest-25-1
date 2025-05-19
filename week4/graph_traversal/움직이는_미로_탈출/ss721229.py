# 1h 30m
import sys
from collections import deque
input = sys.stdin.readline

def move_wall(map):
    new_map = [['.'] * 8 for _ in range(8)]
    for i in range(1, 8):
        new_map[i] = map[i - 1][:]
    return new_map


def bfs(chess_map):
    queue = deque([(7, 0)])
    cnt = 0
    while queue:
        for _ in range(len(queue)):
            item_y, item_x = queue.popleft()
            
            if chess_map[item_y][item_x] == '#':
                continue

            if item_y == 0 and item_x == 7:
                return 1

            directions = [(0, 0), (0, 1), (0, -1), (1, 0), (-1, 0),
                        (-1, 1), (1, 1), (1, -1), (-1, -1)]
            
            for dy, dx in directions:
                ny, nx = item_y + dy, item_x + dx
                if 0 <= ny < 8 and 0 <= nx < 8 and chess_map[ny][nx] != '#':
                    queue.append((ny, nx))

        chess_map = move_wall(chess_map)

        cnt += 1
        if cnt == 9:
            return 1
    return 0

chess_map = [list(input().rstrip()) for _ in range(8)]
print(bfs(chess_map))