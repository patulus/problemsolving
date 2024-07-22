#include <iostream>

using namespace std;

int main(void) {
    int floor;

    cin >> floor;

    // right align star
    for (int i = 0; i < floor; i++) {
        // space
        for (int j = floor - i - 1; j > 0; j--) {
            cout << " ";
        }
        // star
        for (int j = 0; j < i + 1; j++) {
            cout << "*";
        }
        // end line
        cout << endl;
    }

    return 0;
}