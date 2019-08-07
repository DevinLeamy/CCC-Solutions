#include <iostream>

using namespace std;

int main()
{
    int A, B, L;
    cin >> A >> B;
    L = 2;
    while (true){
        int hold = A;
        A = B;
        B = hold - B;
        L++;
        if (B > A){
            break;
        }
    }
    cout << L << endl;
    return 0;
}