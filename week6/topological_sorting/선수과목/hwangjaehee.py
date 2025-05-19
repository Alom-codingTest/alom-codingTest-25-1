from collections import deque #양쪽 끝에서 요소를 추가하거나 제거하는 데 특화된 자료구조 (덱)
 
# 입력
N, M = map(int, input().split()) # 과목 수 N(노드 수), 선수조건 수 M(간선 수)

# 진입차수와 그래프 초기화
indegree = [0] * (N + 1) #각 인덱스(과목번호)별로 진입차수 저장
graph = [[] for _ in range(N + 1)] #각 리스트별로 뒤에 들어야 하는 과목번호 저장(편의상 크기 N+1인 빈 리스트들의 리스트 생성)

# 선수과목 조건 입력받기기
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    indegree[B] += 1

# 각 과목을 이수할 수 있는 최소 학기를 저장하는 리스트
#semester = [1] * (N + 1)  # 기본적으로 1학기부터 시작

# 위상 정렬
def topology_sort():
    # 각 과목을 이수할 수 있는 최소 학기를 저장하는 리스트
    semester = [1] * (N + 1)  # 기본적으로 1학기부터 시작
    q = deque() #진입차수가 0인 과목 번호 넣어둘 큐

    # 진입차수가 0인 과목 번호 큐에 삽입 (선수과목이 없는 과목들)
    for i in range(1, N + 1):
        if indegree[i] == 0: # 진입 차수가 0이면 큐에 넣기
            q.append(i)

    while q:
        now = q.popleft() # now : 현재 처리 중인 과목번호

        for next in graph[now]: # next: 현재 처리 중인 과목 뒤에 들어야 할 과목번호
            indegree[next] -= 1
            '''
            다음 과목의 최소 학기는 현재 과목의 학기 + 1
            next 과목에는 now 외에도 여러 개의 선수과목이 있을 수 있으므로
            해당 과목의 모든 선수과목 중 가장 늦게 끝나는 과목에 따라 해당 과목의 최소 이수 학기를 갱신
            '''
            semester[next] = max(semester[next], semester[now] + 1)
            if indegree[next] == 0:
                q.append(next)

    # 1번 과목부터 N번 과목 순서대로 이수 가능 학기 출력 
    for i in range(1,len(semester)):
        print(semester[i],end=' ')

topology_sort()
