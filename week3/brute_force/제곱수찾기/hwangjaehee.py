max_square = -1
N, M = map(int, input().split())

# 표의 숫자를 저장할 리스트
maps = []
for _ in range(N):
    line = input().strip()
    maps.append(line)

# 각 시작 위치와 방향을 탐색
for start_row in range(N):
    for start_col in range(M):
        # 행과 열의 증가량을 설정
        for row_step in range(-N, N):
            for col_step in range(-M, M):
                # 행과 열의 증가량이 모두 0인 경우는 건너뜀
                if row_step == 0 and col_step == 0:
                    continue
                
                # 현재 위치와 이어붙일 숫자 초기화
                current_row = start_row
                current_col = start_col
                number_str = ''
                
                # 현재 위치가 표의 범위 내에 있는 동안 반복
                while 0 <= current_row < N and 0 <= current_col < M:
                    # 현재 위치의 숫자를 이어붙임
                    number_str += maps[current_row][current_col]
                    
                    # 이어붙인 숫자가 완전 제곱수인지 확인
                    if int(int(number_str) ** 0.5) ** 2 == int(number_str):
                        max_square = max(max_square, int(number_str))
                    
                    # 다음 위치로 이동
                    current_row += row_step
                    current_col += col_step

# 결과 출력
print(max_square)
