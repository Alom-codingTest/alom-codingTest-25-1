total = 0

def pdf(p, diff):
    return (p[0] + diff[0] - 1, p[1] + diff[1] - 1)

def process(N, p1, p2, y, x):
    global total

    if N == 0:
        return

    # divide & conquer
    l_now = p2[0] - p1[0] + 1  # (0, 0) (3, 3) -> 4
    l_next = l_now // 2  # 2

    if p1[0] <= y < p1[0] + l_next and p1[1] <= x < p1[1] + l_next:
        total += (4 ** (N - 1)) * 0
        process(N-1, p1, pdf(p1, (l_next, l_next)), y, x)

    if p1[0] <= y < p1[0] + l_next and p1[1] + l_next <= x < p1[1] + l_now:
        total += (4 ** (N - 1)) * 1
        process(N-1, pdf(p1, (1, l_next + 1)), pdf(p1, (l_next, l_now)), y, x)

    if p1[0] + l_next <= y < p1[0] + l_now and p1[1] <= x < p1[1] + l_next:
        total += (4 ** (N - 1)) * 2
        process(N-1, pdf(p1, (l_next + 1, 1)), pdf(p1, (l_now, l_next)), y, x)

    if p1[0] + l_next <= y < p1[0] + l_now and p1[1] + l_next <= x < p1[1] + l_now:
        total += (4 ** (N - 1)) * 3
        process(N-1, pdf(p1, (l_next + 1, l_next + 1)), p2, y, x)


if __name__ == "__main__":
    N, y, x = map(int, input().split())
    process(N, (0, 0), (2**N-1, 2**N-1), y, x)
    print(total)
    # print(process(2**N, y, x))




# 3, 4, 5 -> 8x8, (4, 5)
# N = 8 -> (0, 0) ~ (3, 3) -> 