#include <iostream>

using namespace std;

int main(void) {
    char temp[256];
    char collations[5] = { 'a', 'i', 'u', 'e', 'o' };
    int cnt = 0;

    do {
        cin.getline(temp, 256);

        int idx = 0;
        while (tolower(temp[idx]) != '\0') {
            for (int i = 0; i < 5; i++) {
                if (tolower(temp[idx]) == collations[i]) {
                    cnt++;
                }
            }
            idx++;
        }
        if (temp[0] != '#')
            cout << cnt << endl;
        cnt = 0;
    } while (temp[0] != '#');

    return 0;
}