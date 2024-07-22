#include <iostream>

using namespace std;

int main(void) {
    int floor;

    cin >> floor;

    // reverse align star
    for (int i = 0; i < floor; i++) {
        for (int j = floor - i; j > 0; j--) {
            cout << "*";
        }
        cout << endl;
    }

    return 0;
}