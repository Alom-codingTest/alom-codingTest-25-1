#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<string> image;

//압축 함수
string compress(int x, int y, int size) {
    char first = image[x][y];
    bool same = true;

    for (int i = x; i < x + size; ++i) {
        for (int j = y; j < y + size; ++j) {
            if (image[i][j] != first) {
                same = false;
                break;
            }
        }
        if (!same) break;
    }

    if (same) {
        return string(1, first);
    }

    // 쪼개진 경우
    int half = size / 2;
    return "(" +
        compress(x, y, half) +
        compress(x, y + half, half) +
        compress(x + half, y, half) +
        compress(x + half, y + half, half) +
        ")";
}

int main() {
    int N;
    cin >> N;
    image.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> image[i];
    }

    cout << compress(0, 0, N) << endl;

    return 0;
}
