## Z-1074
1. divide 함수
- n이 0이 되면 return 0
- boxLen > 2^(n-1)
- boxSize > (2^(n-1) * 2^(n-1))
- 현재 위치 이전에 처리된 것들 sum에 합
- 현재 위치 기준 box에 대해 divide 함수 재귀 호출
2. 최종 divide 리턴값 출력