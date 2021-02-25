#include <iostream>

using namespace std;

int main() {
    int b; cin >> b;
    int p = 5 * b - 400;
    int loc = 0;
    if (b < 100) loc = 1;
    if (b > 100) loc = -1;
    printf("%d\n%d\n", p, loc);
}