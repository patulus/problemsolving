#include <iostream>

using namespace std;

int main(void) {
    int trials;
    int repeats;
    char sentence[21];

    cin >> trials;

    for (int i = 0; i < trials; i++) {
        cin >> repeats >> sentence;

        int now = 0;
        while (sentence[now] != '\0') {
            for (int i = 0; i < repeats; i++) {
                cout << sentence[now];
            }
            now++;
        }
        cout << endl;
    }

    return 0;
}