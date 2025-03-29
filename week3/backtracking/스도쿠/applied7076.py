def check(y, x, board):
    for i in range(9):
        if i != x and board[y][i] == board[y][x]:  # 가로 동일
            return False
        if i != y and board[i][x] == board[y][x]:  # 세로 동일
            return False
    
    # start value -> 0, 3, 6
    start_y = (y // 3) * 3
    start_x = (x // 3) * 3

    for _y in range(3):
        for _x in range(3):
            if start_y + _y != y and start_x + _x != x and board[start_y + _y][start_x + _x] == board[y][x]:
                return False
            
    return True

def execute(board):
    for y in range(9):
        for x in range(9):
            if board[y][x] == 0:
                for num in range(1, 10):
                    board[y][x] = num  # 일단 넣고

                    if check(y, x, board):
                        if execute(board): # 재귀적으로 다 넣어봤는데 OK가 뜨면?
                            return True # 얘도 OK
                    
                    board[y][x] = 0  # 그게 아니면 다시 빈 칸으로, 나중에 다른 값으로 재시도
                
                return False # 다 넣어봤는데도 안되면 False
            
    return True # 0이 더 이상 남아있지 않으면 OK
    

if __name__ == "__main__":
    board = [[0] * 9 for _ in range(9)]

    for l in range(9):
        board[l] = list(map(int, input().split()))

    if execute(board):
        for l in range(9):
            print(*board[l])
