#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++){
        int C;
        string character;
        cin >> C >> character;
        string output = "";
        for (int j = 0; j < C; j++){
            output += character;
        }
        cout << output << endl;
    }
    return 0;
}