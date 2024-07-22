#include <iostream>
using namespace std;

int main(void) {
    int N;

    cin >> N;

    for (int floor = 0; floor < N; floor++) {
        for (int star = 0; star < floor + 1; star++) {
            cout << "*";
        }
        cout << endl;
    }

    return 0;
}