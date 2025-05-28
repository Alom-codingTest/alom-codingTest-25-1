from sys import stdin

l, r = map(str, stdin.readline().rstrip().split()) # 왼손과 오른손 검지손가락의 초기 위치 문자 읽기
string = stdin.readline().rstrip() #입력해야 할 문자열을 읽기

keyboard = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm']
mo = 'yuiophjklbnm' #모음 리스트
xl, yl, xr, yr = None, None, None, None #왼손좌표행렬, 오른손 좌표 행렬(초기화)

# 키보드 배열을 순회하며 왼손과 오른손 검지손가락의 초기 위치 문자에 해당하는 좌표 찾기기
for i in range(len(keyboard)):
    # 현재 행 keyboard[i]에 왼손 초기 위치 문자 l이 있는지 확인
    if l in keyboard[i]: # 있다면 해당 행 i와 해당 문자의 열 인덱스를 찾아 xl, yl에 저장합니다.
        xl, yl = i, keyboard[i].index(l)

    # 오른손 초기 위치 문자 r이 있는지 확인
    if r in keyboard[i]: # 있다면 해당 행 i와 해당 문자의 열 인덱스를 찾아 xr, yr에 저장
        xr, yr = i, keyboard[i].index(r)

ans = 0 # 총 걸린 시간을 저장할 변수를 초기화
for s in string:
    ans += 1  # 각 문자를 누르는 데 기본적으로 1만큼의 시간이 소요

    #오른손으로 눌러야 하는 경우(모음)
    if s in mo:
        for i in range(len(keyboard)):
            if s in keyboard[i]: # 문있다면 해당 행 i와 해당 문자의 열 인덱스를 nx, ny에 저장
                nx = i
                ny = keyboard[i].index(s)
                # 맨해튼 거리 = |행 차이| + |열 차이|
                ans += abs(xr - nx) + abs(yr - ny)

                xr, yr = nx, ny
                break  # 문자를 찾았으므로 내부 루프는 중단하고 다음 문자로 넘어가기기

    #왼손으로 눌러야 하는 경우
    else:
        for i in range(len(keyboard)):
            if s in keyboard[i]:
                nx = i
                ny = keyboard[i].index(s)

                ans += abs(xl - nx) + abs(yl - ny)

                xl, yl = nx, ny
                break

print(ans)