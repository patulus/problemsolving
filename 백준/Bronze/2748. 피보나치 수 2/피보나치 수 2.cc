#include <iostream>

using namespace std;

long long Fibonacci(int idx);

int main() {
    int idx;

    cin >> idx;
    cout << Fibonacci(idx) << endl;

    return 0;
}

long long Fibonacci(int idx) {
    long long temp = 0;
    long long cur = 0;
    long long prev = 1;

    for (int i = 0; i < idx; i++) {
        temp = cur;
        cur += prev;
        prev = temp;
    }

    return cur;
}