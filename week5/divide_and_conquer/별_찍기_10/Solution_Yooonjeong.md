## 별 찍기-10-2447
1. arr > 결과를 담을 char 배열
2. printStar 함수
- n이 1일 때 현재 위치에 '*' 찍기
- n은 3의 배수, 3*3번 반복하며 재귀호출
- 9번의 반복 중 i=1, j=1인 경우는 printBlank 호출
3. printBlank 함수
- 현재 위치에 n*n만큼 ' ' 찍기