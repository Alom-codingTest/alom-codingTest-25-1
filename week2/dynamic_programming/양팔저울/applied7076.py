iron_cnt = int(input())
irons = list(map(int, input().split()))

able_g = set()

for iron in irons:
    tmp_set = set()

    # 현재 가능한 모든 조합에 추 하나씩 추가
    # 가능 수 + 추 무게, 가능 수 - 추 무게
    # 혹은 현재 추 무게 그대로
    for g in able_g:
        tmp_set.add(abs(g - iron))
        tmp_set.add(g + iron)

    # 모두 가능한 조합으로 추가
    able_g |= tmp_set
    able_g.add(iron)

ball_cnt = int(input())
balls = list(map(int, input().split()))

answers = [("Y" if X in able_g else "N") for X in balls]
print(" ".join(answers))
