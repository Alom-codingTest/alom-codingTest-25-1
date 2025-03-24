# # key가 b, value가 a
# # 1   2   3   4   5   6
# #   [1]
# #       [1]
# #                [2]
# #                [4]
def calculate_prerequisites(course_num):
    # 이미 계산된 경우 다시 계산하지 않음 (시간초과 방지_메모이제이션)
    if semester[course_num] != 0:
        return semester[course_num]

    # 선수과목이 없는 경우 1학기에 이수 가능
    if course_num not in prerequisite:
        semester[course_num] = 1
        return 1

    # 해당 과목의 선수과목들 중 가장 늦게 들을 수 있는 학기 + 1
    max_semester = 0
    for precourse in prerequisite[course_num]:  # 해당 과목의 선수과목의 선수과목 점검
        max_semester = max(max_semester, calculate_prerequisites(precourse))

    semester[course_num] = max_semester + 1
    return semester[course_num]

# 입력 받기
N, M = map(int, input().split())

prerequisite = {}  # 선수과목 정보 딕셔너리 (key:과목 value:해당 과목의 선수과목s)
semester = [0] * (N + 1)  # 각 과목의 이수 가능 최소 학기(인덱스와 각 과목명을 일치시키기 위해 N+1개 생성_semester[n] → n번 과목 이수 가능 최소 학기)

# 선수과목 정보 저장
for i in range(M):
    a, b = map(int, input().split())
    if b not in prerequisite:
        prerequisite[b] = []  # b에 대한 값이 없으면(만들어야 하면) 초기화
    prerequisite[b].append(a)  # key가 b, value가 a

# 각 과목의 이수 가능 학기 계산
result = []
for course in range(1, N + 1):
    result.append(str(calculate_prerequisites(course)))

# 결과 출력
print(" ".join(result))