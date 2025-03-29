# 1h
import sys
from collections import deque

input = sys.stdin.readline

def bfs(arr, start):
    queue = deque([(start, 0)])
    visited = set()
    visited.add(tuple(start))

    while queue:
        state, num = queue.popleft()

        if state == arr:
            return num

        next_states = []

        # 행
        for i in range(3):
            new_state = state[:]
            for j in range(3):
                new_state[i * 3 + j] = not new_state[i * 3 + j]
            next_states.append(new_state)

        # 열
        for i in range(3):
            new_state = state[:]
            for j in range(3):
                new_state[j * 3 + i] = not new_state[j * 3 + i]
            next_states.append(new_state)

        # 대각선
        new_state = state[:]
        for i in range(3):
            new_state[i * 4] = not new_state[i * 4]
        next_states.append(new_state)

        # 대각선
        new_state = state[:]
        for i in range(1, 4):
            new_state[i * 2] = not new_state[i * 2]
        next_states.append(new_state)
    
        # 큐에 추가 (방문한 상태는 제외)
        for new_state in next_states:
            state_tuple = tuple(new_state)
            if state_tuple not in visited:
                visited.add(state_tuple)
                queue.append((new_state, num + 1))

    return -1

T = int(input())
l = []
st_t = [True] * 9
st_h = [False] * 9

for _ in range(T):
    tmp = []
    for __ in range(3):
        tmp.extend([True if x == 'T' else False for x in input().rstrip().split()])
    l.append(tmp)

for arr in l:
    print(min(bfs(arr, st_t), bfs(arr, st_h)))