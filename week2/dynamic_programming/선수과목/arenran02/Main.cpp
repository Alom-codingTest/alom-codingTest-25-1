#include <iostream>
#include <vector>
#include <deque>

#define MAX 1001

using namespace std;

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    int N, M;
    cin >> N >> M;

    // - 위상 정렬로 구현

    // 선수과목 저장
    deque<int> prev [MAX];
    // 접근 차수
    int degree [MAX] = {0};
    // 결과값
    int result [MAX] = {1};

    // 들었던 수업 저장
    deque<int> done;
    
    int first, second;

    // 선수과목 조건 입력
    for (int i=0; i<M; i++){
        cin >> first;
        cin >> second;

        // 선수과목 인덱스에 후속 과목 저장
        prev[first].push_back(second);
        degree[second]++;
    }

    // 차수가 0인 모든 과목 done에 저장
    for (int i=1; i<N+1; i++){
        if (degree[i]==0){
            done.push_back(i);
            degree[i]--;

            // 처음이 아니면 횟수 증가
            if (result[i]!=1) result[i]++;

            // 후속 과목 차수 -1
            for (int num: prev[i]){
                degree[num]--;
            }
        }
    }

    // 큐가 비기 전까지 실행
    while(!done.empty()){

        // 큐의 맨 앞 요소 꺼내기 
        int cur = done.front();
        done.pop_front();

        for (int i=0; i<size(prev[cur]); i++){
            int next = prev[cur][i];
            degree[next]--;

            // 다른 과목들에 의한 result값 고려
            result[next] = max(result[next], result[cur]+1);

            if (degree[next]==0){
                done.push_back(next);
            }
        }
    }

    for (int i=1; i<N; i++){
        cout << result[i] << " ";
    }

    cout << result[N];

    return 0;
}