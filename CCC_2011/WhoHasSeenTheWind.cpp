#include <iostream>

using namespace std;

int pow(int num, int pow){
    int current = num;
    for (int i = 0; i < (pow - 1); i++){
        current *= num;
    }
    return current;
}
int main()
{
    int MAX, H;
    bool found = false;
    int at = 0;
    cin >> H >> MAX;
    for (int t = 1; t <= MAX; t++){
        int A = -6 * (pow(t, 4)) + H * pow(t, 3) + 2 * pow(t, 2)+ t;
        if (A <= 0){
            found = true;
            at = t;
            break;
        }
    }
    if (found){
        cout << "The balloon first touches ground at hour:\n" << at << endl;
    } else{
        cout << "The balloon does not touch ground in the given time." << endl;
    }
    return 0;
}