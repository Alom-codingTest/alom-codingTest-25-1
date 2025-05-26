import sys
input = sys.stdin.readline

def stuff_1(direction):
    if direction == 'd':
        return [1, 0, 'd']
    elif direction == 'u':
        return [-1, 0, 'u']
    else: # r, l
        return [0, 0, 'stop']
    
def stuff_2(direction):
    if direction == 'r':
        return [0, 1, 'r']
    elif direction == 'l':
        return [0, -1, 'l']
    else: # u, d
        return [0, 0, 'stop']

def stuff_3(direction):
    if direction == 'u':
        return [0, 1, 'r']
    elif direction == 'd':
        return [0, -1, 'l']
    elif direction == 'l':
        return [1, 0, 'd']
    else: # r
        return [-1, 0, 'u']

def stuff_4(direction):
    if direction == 'd':
        return [0, 1, 'r']
    elif direction == 'u':
        return [0, -1, 'l']
    elif direction == 'r':
        return [1, 0, 'd']
    else: # l
        return [-1, 0, 'u']


N, M = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]
result = [[0] * M for _ in range(N)]
cnt = 0

for i in range(N):
    for j in range(M):
        if room[i][j] == 9:
            cnt += 1

            dx = [0, 0, -1, 1]
            dy = [-1, 1, 0, 0]
            cmd_list = ['u', 'd', 'l', 'r']
            for k in range(4):
                y, x = i, j
                tmp_dy, tmp_dx = dy[k], dx[k]
                cmd = cmd_list[k]
                while 0 <= y + tmp_dy < N and 0 <= x + tmp_dx < M:
                    y += tmp_dy
                    x += tmp_dx
                    if room[y][x] == 0:
                        room[y][x] = 5
                    elif cmd == 'stop':
                        break
                    elif room[y][x] == 1:
                        tmp_dy, tmp_dx, cmd = stuff_1(cmd)
                    elif room[y][x] == 2:
                        tmp_dy, tmp_dx, cmd = stuff_2(cmd)
                    elif room[y][x] == 3:
                        tmp_dy, tmp_dx, cmd = stuff_3(cmd)
                    elif room[y][x] == 4:
                        tmp_dy, tmp_dx, cmd = stuff_4(cmd)
                    elif room[y][x] == 9:
                        break
                    
                    if not result[y][x]:
                        cnt += 1
                    result[y][x] = 1

print(cnt)