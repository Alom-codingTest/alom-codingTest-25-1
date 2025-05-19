from collections import deque

def method(N, M, prerequisites):
    graph = [[] for _ in range(N + 1)] 
    what_degree = [0] * (N + 1)  # 과목의 진입학기
    semesters = [1] * (N + 1)  # 과목 이수 학기
    
    for A, B in prerequisites:
        graph[A].append(B) 
        what_degree[B] += 1  

    queue = deque()
    for i in range(1, N + 1):
        if what_degree[i] == 0:
            queue.append(i)  # 바로 이수

    while queue:
        course = queue.popleft()
        for next_course in graph[course]:
            what_degree[next_course] -= 1  # 진입 차수 감소
            # 최소 학기
            semesters[next_course] = max(semesters[next_course], semesters[course] + 1)
            # 마지막
            if what_degree[next_course] == 0:
                queue.append(next_course)

    print(" ".join(map(str, semesters[1:])))

#main
N, M = map(int, input().split())
prerequisites = [tuple(map(int, input().split())) for _ in range(M)]
method(N, M, prerequisites)
