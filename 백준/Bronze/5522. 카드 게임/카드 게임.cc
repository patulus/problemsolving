#include <iostream>

using namespace std;

int main() {
    int submittedScore;
    int sum = 0;

    for (int i = 0; i < 5; i++) {
        cin >> submittedScore;
        sum += submittedScore;
    }

    cout << sum << endl;

    return 0;
}