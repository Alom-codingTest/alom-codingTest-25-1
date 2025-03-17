#include <iostream>
using namespace std;

static int count = 0;

void swap(int* a, int* b){
    int temp = *b;
    *b = *a;
    *a = temp;
}

void downHeap(int* a, int index){
    int largest = index;
    int left = index * 2;
    int right = index * 2 + 1;

    if (left <= ::count && a[left] > a[largest]) {
        largest = left;
    }
    if (right <= ::count && a[right] > a[largest]) {
        largest = right;
    }

    if (largest != index) {
        swap(&a[index], &a[largest]);
        downHeap(a, largest);
    }
}

void pop(int* data){
    if (::count == 0) {
        cout << 0 << '\n';
        return;
    }

    cout << data[1] << '\n';
    data[1] = data[::count];
    data[::count--] = 0;

    downHeap(data, 1);
}

void push(int* a, int number){
    int back = ++::count;
    a[back] = number;

    while (back > 1 && a[back] > a[back / 2]) {
        swap(&a[back], &a[back / 2]);
        back /= 2;
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    int* data = new int[N + 1];

    // 배열 초기화
    for (int i = 0; i <= N; i++) {
        data[i] = 0;
    }

    for (int i = 0; i < N; i++){
        int num;
        cin >> num;

        if (num == 0) {
            pop(data);
        } else {
            push(data, num);
        }
    }

    delete[] data; // 메모리 해제
    return 0;
}
