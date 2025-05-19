## Solution by Jihun Kim

### 2630: 색종이 만들기 
```python
def pdf(p, diff):
    return (p[0] + diff[0] - 1, p[1] + diff[1] - 1)

def check(p1, p2):  # p1과 p2 사이의 모든 값 더하기
    global r0, r1

    total = 0
    l = p2[0] - p1[0] + 1     # 이 때 크기는 l^2

    for y in range(p1[0], p2[0] + 1):
        for x in range(p1[1], p2[1] + 1):
            total += board[y][x]

    if total == l ** 2:     # 모두 1이면 합은 l^2
        r1 += 1
        return True
    
    elif total == 0:        # 모두 0이면 합은 0
        r0 += 1
        return True
    
    return False            # 이외에는 다른 수가 존재함


def process(p1, p2):
    if check(p1, p2):
        return
    
    # divide & conquer
    # 현재 길이 기준으로 2x2등분해서 하위 재귀로 진행
    l_now = p2[0] - p1[0] + 1  # (0, 0) (3, 3) -> 4
    l_next = l_now // 2  # 2

    process(p1, pdf(p1, (l_next, l_next)))
    process(pdf(p1, (1, l_next + 1)), pdf(p1, (l_next, l_now)))
    process(pdf(p1, (l_next + 1, 1)), pdf(p1, (l_now, l_next)))
    process(pdf(p1, (l_next + 1, l_next + 1)), p2)
```


### 17829: 222 풀링
```python
def get_next(p):   # 포인트 기준으로 4칸에서 2번째 최댓값 반환
    y, x = p
    li = [board[y+i][x+j] for i in range(2) for j in range(2)]
    li.sort()
    return li[-2]  # 오름차순 정렬 후 역순에서 2번째


def process(l):
    global board

    if l == 1:   # 길이가 1이면 최종
        return
    
    temp = [[0 for __ in range(l // 2)] for _ in range(l // 2)]
    for y in range(l // 2):
        for x in range(l // 2):
            temp[y][x] = get_next((y * 2, x * 2))  # 현재 좌표에 대해서 하나로 압축해서 새로운 리스트에 삽입

    board = deepcopy(temp)    # 보드를 반토막낸 리스트로 갱신
    process(l // 2)           # 길이 반토막으로 재귀적 진행
```


### 1074: Z

> [!WARNING]  
> 코드가 깨끗하지 않습니다. (Code is not cleaned.)

```python
def pdf(p, diff):
    return (p[0] + diff[0] - 1, p[1] + diff[1] - 1)

def process(N, p1, p2, y, x):
    global total

    if N == 0:
        return

    # divide & conquer
    l_now = p2[0] - p1[0] + 1  # (0, 0) (3, 3) -> 4
    l_next = l_now // 2  # 2

    # 좌표를 확인하면서 0, 1, 2, 3 처리
    # 매 탐색에서 4^(N-1) * index만큼 더하게 됨
    # [4, 0, 3] -> 4*4^2 + 0*4^1 + 3*4^0 이런 식...

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
```


### 2447 : 별 찍기 10
```python

# N이 3^7까지라 naive하게 배열로 때려박아도 됩니다
board = [[' ' for _ in range(3**7 + 1)] for _ in range(3**7 + 1)]

def process(N, y, x):
    if N == 1:    # 사이즈 1까지 왔으면 별
        board[y][x] = '*'
        return
    
    # 3x3등분하면서 가운데 탐색
    for _y in range(3):
        for _x in range(3):
            if _y == 1 and _x == 1:
                continue
            process(N // 3, y + N // 3 * _y, x + N // 3 * _x)

                    
if __name__ == "__main__":
    N = int(input())
    process(N, 0, 0)
    for y in range(N):
        print(''.join(board[y][:N]))
```