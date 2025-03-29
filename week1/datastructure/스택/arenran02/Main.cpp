#include <iostream>
#include <queue>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    int N;
    int* data;

    string comm; 
    int num;
    int top=-1;    // 스택의 맨 위를 나타내는 변수

    cin >> N;

    // 명령어 개수만큼 배열 할당
    data = new int[N];

    for (int i = 0; i < N; i++) {
        cin >> comm;
        if (comm == "push") {
            cin >> num;
            data[++top] = num;
        }
        else if (comm == "pop") {
            if (top + 1 == 0 ) cout << "-1" << '\n';
            else cout << data[top--] << '\n';
        }
        else if (comm == "size") {
            cout << top + 1 << '\n';
        }
        else if (comm == "empty") {
            if (top + 1 == 0) cout << "1" << '\n';
            else cout << "0" << '\n';
        }
        else if (comm == "top") {
            if (top + 1 == 0) cout << "-1" << '\n';
            else cout << data[top] << '\n';
        }
    }

    delete[] data;

    return 0;
}