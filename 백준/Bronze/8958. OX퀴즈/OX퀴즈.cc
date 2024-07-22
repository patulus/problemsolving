#include <iostream>

using namespace std;

int main(void) {
    int repeats;
    char isAnswer[81];

    cin >> repeats;

    for (int i = 0; i < repeats; i++) {
        cin >> isAnswer;

        int sum = 0;
        int point = 0;
        int j = 0;
        while (isAnswer[j] != '\0') {
            if (isAnswer[j] == 'O') {
                point++;
                sum += point;
            }
            else if (isAnswer[j] == 'X') {
                point = 0;
            }
            j++;
        }
        cout << sum << endl;
    }

    return 0;
}