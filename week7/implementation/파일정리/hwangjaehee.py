N = int(input())
dic = {} # 확장자를 담아줄 딕셔너리
for i in range(N):
    _, extend = input().split('.') # .기준으로 문자열 분리
    if extend in dic: # 딕셔너리에 확장자가 있다면 개수를 추가
        dic[extend] += 1
    else: # 없다면 새로 등록
        dic[extend] = 1

for key in sorted(dic.keys()): # 딕셔너리의 key를 오름차순 정렬
    print(key, dic[key])