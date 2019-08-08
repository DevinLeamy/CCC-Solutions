#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++){
        string line;
        cin >> line;
        string output = "";
        int count = 0; 
        char current = line.at(0);
        for (int j = 0; j < line.length(); j++){
            char character = line.at(j);
            if (character != current){
                output += to_string(count);
                output += " ";
                output += current;
                output += " ";
                count = 1;
                current = character;
            } else {
                count++;
            }
        }
        output += to_string(count);
        output += " ";
        output += current;
        cout << output << endl;
    }
    return 0;
}