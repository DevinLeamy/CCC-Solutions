#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m; cin >> n >> m;
    vector<vector<int> > matrix(n, vector<int>(m));
    vector<int> rows(n);
    vector<int> cols(m);
    int c; cin >> c;
    for (int i = 0; i < c; i++) {
        string cmd; int val; cin >> cmd >> val;
        if (cmd == "R") { rows[val - 1]++; } 
        else { cols[val - 1]++; } 
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matrix[i][j] = rows[i];
        }
    }
    int total = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            matrix[j][i] += cols[i];
            if (matrix[j][i] % 2 == 1) 
                total++;
        }
    }
    cout << total << endl; 
}