n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]

def count_colors(x, y, size):
    color = paper[x][y] #기준이 되는 색
    same = True
    #색이 섞여 있는지 검사
    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper[i][j] != color:
                same = False
                break
        if not same:
            break

    # 색이 모두 같을 경우
    if same:
        if color == 0:
            return (1, 0)  # 흰색 1개, 파란색 0개
        else:
            return (0, 1)  # 흰색 0개, 파란색 1개
    # 그러지 않을 경우
    else:
        half = size // 2
        result = [count_colors(x, y, half),
                  count_colors(x, y + half, half),
                  count_colors(x + half, y, half),
                  count_colors(x + half, y + half, half)]
        # 분할 결과 합치기
        white = 0
        blue = 0
        for w, b in result:
            white += w
            blue += b
        return (white, blue)

white, blue = count_colors(0, 0, n)
print(white)
print(blue)
