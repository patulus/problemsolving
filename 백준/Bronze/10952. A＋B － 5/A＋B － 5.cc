#include <iostream>

using namespace std;

int main(void) {
    while (1) {
        int i, j;

        cin >> i >> j;

        if (i == 0 && j == 0)
            break;

        cout << i + j << endl;
    }
}