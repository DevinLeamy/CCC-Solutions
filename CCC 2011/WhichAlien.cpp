#include <iostream>

using namespace std;

void isToryMartian(int A, int E){
    if (A >= 3 && E <= 4){
        cout << "TroyMartian\n" << endl;
    }
}
void isVladSaturnian(int A, int E){
    if (A <= 6 && E >= 2){
        cout << "VladSaturnian\n" << endl;
    }
}
void isGraemeMercurian(int A, int E){
    if (A <= 2 && E <= 3){
        cout << "GraemeMercurian\n" << endl;
    }
}
int main()
{
    int A, E;
    cout << "How many antennas?" << endl;
    cin >> A;
    cout << "How many eyes?" << endl;
    cin >> E;
    isToryMartian(A, E);
    isVladSaturnian(A, E);
    isGraemeMercurian(A, E);
    return 0;
}