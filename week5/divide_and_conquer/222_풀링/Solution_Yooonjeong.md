## 222-풀링-17829
1. pooling 메소드
- arr > 현재 행렬
- n > 현재 행렬 크기
- newArr > (n/2)*(n/2) 크기의 pooling 결과를 담을 배열
- 크기가 1*1이라면 남아있는 수 return
- 모든 2*2 행렬에 대해 findSecond 함수로 2번째 큰 수 찾아 newArr에 저장
- 크기가 줄어든 행렬에 대해 pooling 재귀 호출
2. findSecond 메소드
- 4개의 수에 대해 두 번째 큰 수 return