#include <iostream>

using namespace std;

int checkNote(int* notes) {
    if (notes[0] == 1) {
        for (int i = 0; i < 7; i++) {
            if (notes[i + 1] != notes[i] + 1)
                return -1;
        }
        return 0;
    }
    else if (notes[0] == 8) {
        for (int i = 0; i < 7; i++) {
            if (notes[i + 1] != notes[i] - 1)
                return -1;
        }
        return 1;
    }

    return -1;
}

int main(void) {
    int notes[8];
    
    for (int i = 0; i < 8; i++) {
        cin >> notes[i];
    }

    switch (checkNote(notes)) {
        case 0:
            cout << "ascending" << endl; break;
        case 1:
            cout << "descending" << endl; break;
        case -1:
        default:
            cout << "mixed" << endl; break;
    }

    return 0;
}