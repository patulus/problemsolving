#include <iostream>
using namespace std;

int main(void) {
    long long int N, M;
    long long int result;

    cin >> N >> M;

    result = abs(N-M);

    cout << result << endl;

    return 0;
}