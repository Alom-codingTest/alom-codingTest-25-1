MAX = 1000000007
global val

def bfs(start, cnt):
    queue = []
    queue.append((start, cnt))
    val[start] = cnt
    flip = [0b111000000, 0b000111000, 0b000000111, 0b100100100, 0b010010010, 0b001001001, 0b100010001, 0b001010100]

    while queue:
        now, current = queue.pop(0)
        for item in flip:
            next = now ^ item  # XOR로 flip해봐서 다음 값 찾기
            if val[next] == MAX or (val[next] != MAX and val[next] > current + 1):  # 방문한 적 없거나 더 작다면 방문
                val[next] = current + 1
                queue.append((next, current + 1))

if __name__ == "__main__":
    t = int(input())
    val = dict()
    for x in range(2**9):
        val[x] = MAX

    val[0b111111111] = 0  # All heads
    bfs(0b111111111, 0)
    bfs(0b000000000, 0)
    
    # H = 1, T = 0
    for _ in range(t):
        st = ''
        for i in range(3):
            st += input().replace('H', '1').replace('T', '0').replace(' ', '')
        
        num = int(st, 2)
        print(-1 if val[num] == MAX else val[num])