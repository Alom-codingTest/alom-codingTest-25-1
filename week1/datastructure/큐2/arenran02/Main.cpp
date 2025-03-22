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
    int front=0, back=-1;    // 큐의 맨 앞, 맨 뒤 인덱스를 나타내는 변수

    cin >> N;

    // 명령어 개수만큼 배열 할당
    data = new int[N];

    for (int i = 0; i < N; i++) {
        cin >> comm;
        if (comm == "push") {
            cin >> num;
            data[++back] = num;
        }
        else if (comm == "pop") {
            if (back - front + 1 == 0 ) cout << "-1" << '\n';
            else cout << data[front++] << '\n';
        }
        else if (comm == "size") {
            cout << back - front + 1 << '\n';
        }
        else if (comm == "empty") {
            if (back - front + 1 == 0) cout << "1" << '\n';
            else cout << "0" << '\n';
        }
        else if (comm == "front") {
            if (back - front + 1 == 0) cout << "-1" << '\n';
            else cout << data[front] << '\n';
        }
        else if (comm == "back") {
            if (back - front + 1 == 0) cout << "-1" << '\n';
            else cout << data[back] << '\n';
        }
    }

    delete[] data;

    /*

    큐 STL 사용

    queue<int> Q;
    int N, num;
    string comm;
    
    cin >> N; 

    for (int i = 0; i < N; i++) {
        cin >> comm;
        if (comm == "push") {
            cin >> num;
            Q.push(num);
        }
        else if (comm == "pop") {
            if (Q.empty()) {
                cout << "-1" <<  '\n';
            }
            else {
                cout << Q.front() << '\n';
                Q.pop();
            }
        }
        else if (comm == "size") {
            cout << Q.size() <<  '\n';
        }
        else if (comm == "empty") {
            if (Q.empty()) {
                cout << "1" << '\n';
            }
            else {
                cout << "0" << '\n';
            }
        }
        else if (comm == "front") {
            if (Q.empty()) {
                cout << "-1" << '\n';
            }
            else {
                cout << Q.front() << '\n';
            }
        }
        else if (comm == "back") {
            if (Q.empty()) {
                cout << "-1" <<  '\n';
            }
            else {
                cout << Q.back() <<  '\n';
            }
        }
    }

    */

    return 0;
}