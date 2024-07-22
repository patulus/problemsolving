#include <iostream>

using namespace std;

class Report {
    private:
        int students[30];
        int submitted[30];

    public:
        Report() {
            for (int i = 0; i < 30; i++) {
                students[i] = i + 1;
                submitted[i] = 0;
            }
        }

        void submitReport(int studentNumber) {
            submitted[studentNumber - 1] = 1;
        }

        void printNonSubminttedStudents() {
            for (int i = 0; i < 30; i++) {
                if (submitted[i] == 0) {
                    cout << i + 1 << endl;
                }
            }
        }
};

int main() {
    int studentNumber;
    Report xmr;

    for (int i = 0; i < 28; i++) {
        cin >> studentNumber;
        xmr.submitReport(studentNumber);
    }

    xmr.printNonSubminttedStudents();
    

    return 0;
}