#include <iostream>

using namespace std;


int main()
{
    int A = 0;
    int B = 0;
    for (int i = 0; i < 3; i++){
        int score;
        cin >> score;
        score = score * (3 - i);
        A += score;
    }
    for (int i = 0; i < 3; i++){
        int score;
        cin >> score;
        score = score * (3 - i);
        B += score;
    }
    if (A > B){
        cout << "A" << endl;
    } else if (A < B){
        cout << "B" << endl;
    } else {
        cout << "T" << endl;
    }
    return 0;    
}