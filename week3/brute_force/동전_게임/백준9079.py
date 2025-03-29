import sys
input = sys.stdin.readline
from collections import deque

def grid_to_bitmask(grid):
    bitmask = 0
    for i in range(3):
        for j in range(3):
            if grid[i][j] == 'T':  # T는 1, H는 0으로 변환
                bitmask |= (1 << (i * 3 + j))
    return bitmask

flip_patterns = [
    [0, 1, 2],  # 첫 번째 행
    [3, 4, 5],  # 두 번째 행
    [6, 7, 8],  # 세 번째 행
    [0, 3, 6],  # 첫 번째 열
    [1, 4, 7],  # 두 번째 열
    [2, 5, 8],  # 세 번째 열
    [0, 4, 8],  # 좌-> 우 대각선
    [2, 4, 6]   # 우-> 좌 대각선
]


def flip(bitmask, pattern):
    for index in pattern:
        bitmask ^= (1 << index)  # XOR 연산으로 비트를 뒤집음 지피티한테 물어봐버렸읍니다.. 개인적으로 모르겠어서...
    return bitmask

def bfs(start_state):
    queue = deque([(start_state, 0)]) 
    visited = set()
    visited.add(start_state)

    while queue:
        state, steps = queue.popleft()
        if state == 0 or state == 0b111111111:
            return steps
        for pattern in flip_patterns:
            next_state = flip(state, pattern)
            if next_state not in visited:
                visited.add(next_state)
                queue.append((next_state, steps + 1))
    
    return -1

T = int(input())
for _ in range(T):
    grid = [input().split() for _ in range(3)]
    start_state = grid_to_bitmask(grid)
    print(bfs(start_state))
