#include <iostream>

using namespace std;

int GetLstWord(char * str);

int main() {
    int cnt;
    char str[1001];

    cin >> cnt;

    for (int i = 0; i < cnt; i++) {
        cin >> str;
        cout << str[0] << str[GetLstWord(str)] << endl;
    }


    return 0;
}

int GetLstWord(char * str) {
    int idx = 0;

    while(str[idx] != '\0') {
        idx++;
    }

    return idx - 1;
}