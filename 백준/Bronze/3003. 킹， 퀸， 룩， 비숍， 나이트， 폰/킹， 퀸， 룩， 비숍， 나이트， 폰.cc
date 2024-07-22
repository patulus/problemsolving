#include <iostream>

using namespace std;

int main() {
    int N[6];
    int M[6] = {1, 1, 2, 2, 2, 8};

    for (int i = 0; i < 6; i++) {
        cin >> N[i];
    }
    for (int i = 0; i < 6; i++) {
        cout << M[i] - N[i] << " ";
    }
    cout << endl;

    return 0;
}