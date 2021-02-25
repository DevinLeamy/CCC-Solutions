#include <iostream>

using namespace std;

int main() {
   int c; cin >> c;
   string winner = "";
   int bid = -1;
   for (int i = 0; i < c; i++) {
       string person; cin >> person;
       int p_bid; cin >> p_bid;
       if (p_bid > bid) {
           bid = p_bid;
           winner = person;
       }
   }
   cout << winner << endl;
}