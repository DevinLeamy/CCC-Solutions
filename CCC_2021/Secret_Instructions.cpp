#include <iostream>

using namespace std;

int main() {
    int ins; cin >> ins;
    string last_dir = "";
    while (ins != 99999) {
        int first_vals = ins / 1000;
        int rem_vals = ins % 1000;
        int f = first_vals / 10;
        int s = first_vals % 10;
        string dir;
        if ((f + s) % 2 == 1) {
            dir = "left";
        } else if ((f + s) % 2 == 0) {
            dir = "right";
        } else {
            dir = last_dir;
        }
        cout << dir << " " << rem_vals << endl;
        cin >> ins;
        last_dir = dir;
    }
}