n = int(input())  # 2의 제곱수 입력받기
video = [list(map(int, input())) for _ in range(n)]  # 영상 2차원 배열 입력받기

def checkSameNumber(videoBlock):
    first = videoBlock[0][0]
    for row in videoBlock: # 한 줄씩
        for blackOrWhite in row:
            if blackOrWhite != first:
                return False
    return True

def compress(videoBlock):
    if checkSameNumber(videoBlock):
        return str(videoBlock[0][0])
    
    size = len(videoBlock) # 행 수 구하기
    half = size // 2

    # 4분할
    top_left = [row[:half] for row in videoBlock[:half]]
    top_right = [row[half:] for row in videoBlock[:half]]
    bottom_left = [row[:half] for row in videoBlock[half:]]
    bottom_right = [row[half:] for row in videoBlock[half:]]

    # 괄호로 묶어서 재귀 호출
    return "(" + compress(top_left) + compress(top_right) + compress(bottom_left) + compress(bottom_right) + ")"

# 출력
print(compress(video))