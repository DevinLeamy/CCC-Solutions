//15/15 in 0.08s
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define PI pair<int, int>
#define ll long long
#define pb push_back
#define loopX(h) for(int i = 0; i < h; i++)

using namespace std;

bool recur(int, int, int, int);
bool square[5][5] = {
	{false, true, true, true, false},
	{false, false, true, false, false},
	{false, false, false, false, false},
	{false, false, false, false, false},
	{false, false, false, false, false},
};
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int t, x, y, m; cin >> t;
	loopX(t) {
		cin >> m >> x >> y; m--;
		cout << ((recur(y, x, m, 0))? "crystal" : "empty") << endl;
	}
	return 0;
}
bool recur(int row, int col, int mag, int currentMag) {
	if (currentMag == mag) {
		if (mag == 0) {return square[(int)row][(int)col];}
		row = row % (int)pow(5, mag); col = col % (int)pow(5, mag);
		return square[row][col];
	} else {
		int rowM = (row / (int)pow(5, mag - currentMag)) % 5;
		int colM = (col / (int)pow(5, mag - currentMag)) % 5;
		if (square[rowM][colM]) {return true;}
		else if (rowM != 0 && square[rowM-1][colM]) { return recur(row, col, mag, currentMag+1);}
		else {return false;}
	}
	return false;
}
