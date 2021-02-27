#include <iostream>

using namespace std;

int main() {
    string books; cin >> books;
    int lg = 0, med = 0, sml = 0;
    for (int i = 0; i < books.length(); i++) {
        lg += (books[i] == 'L')? 1 : 0;
        med += (books[i] == 'M')? 1 : 0;
        sml += (books[i] == 'S')? 1 : 0;
    }
    string desired = "";
    for (int i = 0; i < books.length(); i++) {
        if (i < lg) { desired += "L"; } 
        else if (i >= lg && i < lg + med) { desired += "M"; } 
        else { desired += "S"; } 
    }
    int sml_swap = 0, lg_swap = 0, md_swap = 0;
    for (int i = 0; i < lg; i++) {
        if (books[i] == desired[i]) continue;
        if (books[i] == 'S') { sml_swap++; }
        if (books[i] == 'M') { md_swap++; }
    }
    for (int i = books.length() - sml; i < books.length(); i++) {
        if (books[i] == desired[i]) continue; 
        if (books[i] == 'L') { lg_swap++; }
        if (books[i] == 'M') { md_swap++; }
    }
    int total_swaps = min(lg_swap, sml_swap) + max(lg_swap, sml_swap) - min(lg_swap, sml_swap) + md_swap;
    cout << total_swaps << endl;
}