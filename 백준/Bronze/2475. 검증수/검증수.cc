#include <iostream>
using namespace std;

int main(void) {
    int N;
    int result = 0;

    for (int i = 0; i < 5; i++) {
        cin >> N;
        result += N * N;
    }

    cout << result % 10 << endl;

    return 0;
}