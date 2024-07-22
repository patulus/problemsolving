#include <iostream>

using namespace std;

int getMin(int * arr, int size) {
    int min = arr[0];

    for (int i = 1; i < size; i++) {
        if (min > arr[i]) {
            min = arr[i];
        }
    }

    return min;
}

int getMax(int * arr, int size) {
    int max = arr[0];

    for (int i = 1; i < size; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
    }

    return max;
}

int main(void) {
    int* arr;
    int size;

    cin >> size;

    arr = new int [size];

    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    cout << getMin(arr, size) << " " << getMax(arr, size) << endl;

    delete arr;

    return 0;
}