## 최대힙

class Max_Heap:
    def __init__(self):
        self.heap = []
        self.idx = -1  # 힙이 비어있을 때 마지막 인덱스: -1
        
    ## idx는 가장 마지막 인덱스
    def parent(self, idx):  ## 부모노드의 인덱스
        return (idx - 1) // 2
    
    def compare_parent(self, idx):  ## 부모노드와 재귀적으로 비교
        n = len(self.heap)
        if n <= 1:  ## 저장된 힙이 없으면 재귀 종료
            return
        if idx > 0:  ## 루트노드 전까지 진행
            parent_index = self.parent(idx)
            if self.heap[parent_index] < self.heap[idx]:
                tmp = self.heap[parent_index]
                self.heap[parent_index] = self.heap[idx]
                self.heap[idx] = tmp
                self.compare_parent(parent_index)

    def insert(self, element):
        self.heap.append(element)
        self.idx += 1  # 새 원소가 추가되었으므로 마지막 인덱스 1 증가
        self.compare_parent(self.idx)  ## 트리 정렬

    def pop(self):  ## 최대 힙 반환
        if self.idx == -1:
            return 0
        else:
            max_val = self.heap[0]  ## 최대값 저장
            # 루트와 마지막 원소 스왑 후, 마지막 노드 삭제
            self.heap[0], self.heap[self.idx] = self.heap[self.idx], self.heap[0]
            self.heap.pop()
            self.idx -= 1  # 삭제 후 마지막 인덱스 1 감소
            self.compare_parent(self.idx)
            return max_val

## main

h = Max_Heap()

num_of_cal = int(input())
for i in range(num_of_cal):
    element = int(input())
    if element == 0:
        result = h.pop()
        print(result)
    else:
        h.insert(element)
