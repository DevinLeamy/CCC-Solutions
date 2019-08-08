#include <iostream>

using namespace std;

int main()
{
    string line;
    cin >> line;
    int H = 0;
    int V = 0;
    for (int i = 0; i < line.length(); i++)
    {
        char character = line.at(i);
        if (character == 'H'){
            H++;
        } else {
            V++;
        }
    }
    if (V % 2 == 0 && H % 2 == 0){
        cout << "1 2" << endl;
        cout << "3 4" << endl;
    } else if (V % 2 == 0){
        cout << "3 4" << endl;
        cout << "1 2" << endl;
    } else if (H % 2 == 0){
        cout << "2 1" << endl;
        cout << "4 3" << endl;
    } else {
        cout << "4 3" << endl;
        cout << "2 1" << endl;
    }
    return 0;
}