import sys
import heapq #최소힙 형태로 저장

N=int(sys.stdin.readline().strip())
maxHeap=[]
for i in range(0,N):
    command=int(sys.stdin.readline().strip())
    if(command == 0):
        if(len(maxHeap)==0):
            print(0)
        else :
            print(-heapq.heappop(maxHeap)) #원소 값 부호 되돌리기기
    
    else:
        heapq.heappush(maxHeap,-command) #원소 값의 부호를 바꿔서 최대힙처럼 동작하도록 함함