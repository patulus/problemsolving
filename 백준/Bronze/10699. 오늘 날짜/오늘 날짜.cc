#include <iostream>
#include <ctime>

using namespace std;

int main() {
    time_t rawtime;
    struct tm * timeinfo;
    char buffer [80];

    time(&rawtime);
    timeinfo = localtime(&rawtime);

    strftime (buffer, 80, "%F", timeinfo);
    cout << buffer << endl;

    return 0;
}