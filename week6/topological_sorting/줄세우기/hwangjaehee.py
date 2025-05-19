from collections import deque #양쪽 끝에서 요소를 추가하거나 제거하는 데 특화된 자료구조 (덱)

# 입력 받기
N, M = map(int, input().split())  # 학생 수 N(노드 수), 비교 수 M(간선 수)

# 진입차수와 그래프 초기화
indegree = [0] * (N + 1) #각 인덱스(학생번호)별로 진입차수 저장(편의상 크기 N+1인 리스트 생성)
graph = [[] for _ in range(N + 1)] #각 리스트별로 뒤에 서야 하는 학생 번호 저장(편의상 크기 N+1인 빈 리스트들의 리스트 생성)

# 학생 순서 관계 입력 받기
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    indegree[B] += 1

# 위상 정렬 함수
def topology_sort():
    result = [] #위상 정렬 결과 저장(후에 순서대로 출력 -> 정답)
    q = deque() #진입차수가 0인 학생 번호 넣어둘 큐

    for i in range(1, N + 1):
        if indegree[i] == 0: # 진입 차수가 0이면 큐에 넣기
            q.append(i)

    while q: # 큐가 빌 때까지 반복
        now = q.popleft() # now : 현재 처리 중인 학생 번호호
        result.append(now)  

        for next in graph[now]: # next: 현재 처리 중인 학생 뒤에 서야 할 학생 번호
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    # 결과 출력
    for i in range(len(result)):
        print(result[i], end=' ') # 숫자를 출력하고 뒤에 공백을 붙임

# 실행
topology_sort()
