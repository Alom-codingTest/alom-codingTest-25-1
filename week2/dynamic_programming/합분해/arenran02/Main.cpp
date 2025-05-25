#include <iostream>

using namespace std;

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    // 0~N까지의 수를 K개 더하여 N을 만들 때
    // 점화식: a(N, K) = a(N, K-1) + a(N-1, K)

    int N, K;

    cin >> N >> K;
    
    // 행렬로 개수 저장 number_list[N][K] 크기
    int** number_list = new int*[N+1];
    for (int i=0; i<N+1; i++){
        number_list[i]=new int [K+1];
    }

    // number_list[N][K] = 조건이 N, K이 주어졌을 때의 개수

    // 초기값 부여 (K=1일 때)
    for (int i=0; i<N+1; i++){
        number_list[i][1]=1;
    }

    // 초기값 부여 (N=0일 때)
    for (int i=0; i<K+1; i++){
        number_list[0][i]=1;
    }

    // 점화식 이용, 값 채우기 (1000000000으로 나눈 나머지 값 출력)
    for (int j=1; j<N+1; j++){
        for (int i=1; i<K+1; i++){
            number_list[j][i]=(number_list[j][i-1]+number_list[j-1][i])% 1000000000;
        }
    }

    cout << number_list[N][K] << '\n';

    for (int i = 0; i < N + 1; i++) {
        delete[] number_list[i];
    }
    delete[] number_list;

    return 0;

}