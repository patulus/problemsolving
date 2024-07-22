#include <iostream>
#include <cstring>

using namespace std;

int main(void) {
    int cnt;
    long long int sum = 0;
    string num;

    cin >> cnt;
    cin >> num;

    for (int i = 0; i < cnt; i++) {
        sum += num[i] - '0';
    }

    cout << sum << endl;
}