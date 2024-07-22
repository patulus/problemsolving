#include <iostream>

using namespace std;

int main(void) {
    while (1) {
        char name[11];
        int age;
        int weight;
        int junior;

        cin >> name >> age >> weight;

        if (name[0] == '#') break;

        if (age > 17 || weight >= 80) {
            junior = 0;
        }
        else {
            junior = 1;
        }

        cout << name << " ";
        if (junior == 1) {
            cout << "Junior" << endl;
        }
        else {
            cout << "Senior" << endl;
        }
    }

    return 0;
}