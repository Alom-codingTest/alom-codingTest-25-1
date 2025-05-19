def backtrack(start, sequence):
    # 길이가 M인 조합이 완성되면 출력
    if len(sequence) == M:
        print(' '.join(map(str, sequence)))  # 수열의 원소를 띄어쓰기로 구분하여 출력
        return
    
    # 수열 구성하기
    for append_idx in range(start, N):
        # 수열에 숫자 추가
        sequence.append(number[append_idx])
        
        # 다음 숫자를 선택하기 위해 재귀 호출
        backtrack(append_idx + 1, sequence)

        # 수열의 마지막 원소 제거
        sequence.pop()

# 입력 받기
N, M = map(int, input().split())
number = list(map(int, input().split()))

# 오름차순 정렬
number.sort()

# 백트래킹 통해 출력할 수열 구성
sequence=[]
backtrack(0, sequence)