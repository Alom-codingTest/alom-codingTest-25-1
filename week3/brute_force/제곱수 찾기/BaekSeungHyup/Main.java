import math

rows, cols = map(int, input().split())
grid = [input().strip() for _ in range(rows)]

max_perfect_square = -1

# 시작 위치 찾기기
for start_row in range(rows):
    for start_col in range(cols):
        # 행,열 간격 정하기기
        for row_step in range(-rows + 1, rows):
            for col_step in range(-cols + 1, cols):
                if row_step == 0 and col_step == 0:
                    continue  # 이동이 없으면 continue

                number_str = ''
                cur_row, cur_col = start_row, start_col

                # 범위안에서만 진행
                while 0 <= cur_row < rows and 0 <= cur_col < cols:
                    number_str += grid[cur_row][cur_col]
                    number = int(number_str)

                    # 완전 제곱수인지 확인
                    if int(math.isqrt(number)) ** 2 == number:
                        max_perfect_square = max(max_perfect_square, number)

                    cur_row += row_step
                    cur_col += col_step

print(max_perfect_square)
