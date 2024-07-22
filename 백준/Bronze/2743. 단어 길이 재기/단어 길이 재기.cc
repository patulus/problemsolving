#include <iostream>

using namespace std;

int main() {
    char str[101];
    int i = 0;

    cin >> str;

    while (str[i] != '\0') {
        i++;
    }

    cout << i << endl;
}