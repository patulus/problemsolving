#include <iostream>

using namespace std;

int main(void) {
    int arr[9];
    int max, maxIdx;

    for (int i = 0; i < 9; i++) {
        cin >> arr[i];
    }

    max = arr[0];
    maxIdx = 1;

    for (int i = 1; i < 9; i++) {
        if (arr[i] > max) {
            max = arr[i];
            maxIdx = i + 1;
        }
    }

    cout << max << endl << maxIdx << endl;

    return 0;
}