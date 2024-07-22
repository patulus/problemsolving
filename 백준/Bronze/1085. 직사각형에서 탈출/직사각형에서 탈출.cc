#include <iostream>

using namespace std;

int main(void) {
    int x, y, w, h;

    cin >> x >> y >> w >> h;

    int minX = (x > w - x) ? w - x : x;
    int minY = (y > h - y) ? h - y : y;
    int result = (minX > minY) ? minY : minX;

    cout << result << endl;

    return 0;
}