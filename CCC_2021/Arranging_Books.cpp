#include <iostream>

using namespace std;

int main() {
    string books; cin >> books;
    int large = 0, med = 0, sml = 0;
    for (int i = 0; i < books.length(); i++) {
        large += (books[i] == 'L')? 1 : 0;
        med += (books[i] == 'M')? 1 : 0;
        sml += (books[i] == 'S')? 1 : 0;
    }
    string desired = "";
    for (int i = 0; i < books.length(); i++) {
        if (i < large) { desired += "L"; } 
        else if (i >= large && i < large + med) { desired += "M"; } 
        else { desired += "S"; } 
    }
    int sl = 0, lg = 0; 
    for (int i = 0; i < large; i++) {
        if (books[i] == desired[i]) continue;
        if (books[i] == 'S') { sl++; }
    }
    for (int i = books.length() - 1; i >= books.length() - sl; i--) {
        if (books[i] == desired[i]) continue; 
        if (books[i] == 'L') { lg++; }
    }
    int total_swaps = min(lg, sl) + max(lg, sl) - min(lg, sl);
    int rem_swaps = 0;
    for (int i = large; i < books.length() - sml; i++) {
        if (books[i] != desired[i]) rem_swaps++;
    }
    total_swaps += rem_swaps;
    cout << total_swaps << endl;
}