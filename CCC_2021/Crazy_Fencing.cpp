#include <iostream>
#include <vector>

using namespace std;

int main() {
    long cnt; cin >> cnt; 
    long double total = 0.0;
    vector<int> widths(cnt);
    vector<int> heights(cnt + 1);
    for (int i = 0; i <= cnt; i++) cin >> heights[i];
    for (int i = 0; i < cnt; i++) cin >> widths[i];
    for (int i = 0; i < cnt; i++) {
        double btm = widths[i] * min(heights[i], heights[i+1]); 
        double top = abs(heights[i] - heights[i + 1]) * widths[i];
        total += (double) btm + 0.5 * top;
    }
    printf("%Lf\n", total);
}