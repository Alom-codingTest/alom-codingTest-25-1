#include <iostream> 

using namespace std;

int main(){

    int N;

    cin >> N;

    // DP 배열 의미
    // DP[i] = i개의 돌이 있을 때 이기는 사람
    int* DP = new int [N+1];

    // 초기화

    // 1개) 상근 승리
    DP[1]=1;
    // 2개) 창영 승리
    DP[2]=0;
    // 3개) 상근 승리
    DP[3]=1;

    for (int i=4; i<=N; i++){
        // 상근이가 이기는 경우
        // 창영이가 이기는 돌의 개수 + 1 or 3개 = 현재 돌의 개수
        // 상근이가 1개 또는 3개를 가져가면 (항상) 이기게 됨
        if (DP[i-1]==0 || DP[i-3]==0){
            DP[i]=1;
        }
        else {
            DP[i]=0;
        }

    }

    if (DP[N]==1) cout << "SK";
    else cout << "CY";

    delete [] DP;

    return 0;
}