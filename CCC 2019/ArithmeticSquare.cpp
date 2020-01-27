//15/15
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
#define loop(h) for(int i = 0; i < h; i++)

using namespace std;

bool recur(int, int, vector<vector<ll>>);
bool check(vector<vector<ll>>);
ll place(int, int, vector<vector<ll>>);
int checkRow(int, int, vector<vector<ll>>);
ll getValue(vector<ll>);
vector<ll> force(vector<vector<ll>>);
vector<vector<ll>> goodSquare;
const ll bad  = -1000000001;
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	vector< vector<ll> > values; string value;
	for (int i = 0; i < 3; i++) {
		values.pb(vector<ll>());
		for (int j = 0; j < 3; j++) {
			cin >> value;
			if (value == "X") {
				values[i].pb(-1000000001);
			} else {
				values[i].pb(stoi(value));
			}
		}
	}
	recur(0, 0, values);
	for (int i = 0; i < 3; i++) {
		string line = to_string(goodSquare[i][0]);
		for (int j = 1; j < 3; j++) {
			line += " ";
			line += to_string(goodSquare[i][j]);
		}
		cout << line << endl;
	}
	return 0;
}
bool recur(int row, int col, vector<vector<ll>> square) {
	if (col == 3) {col = 0; row++;}
	if (row == 3) {  if (check(square)) {  goodSquare = square; return true;  } return false; }
	if (square[row][col] != bad) {
		return recur(row, col+1, square);
	}
	if (force(square).size() != 1) {
		vector<ll> values = force(square);
		square[values[0]][values[1]] = values[2];
		if (recur(row, col, square)) {
			return true;
		}
		square[values[0]][values[1]] = bad;
		return false;
	}
	ll value = place(row, col, square);
	if (value == bad) {
		for (int i = 0; i < 100; i++) {
			square[row][col] = i;
			if (recur(row, col+1, square)) {
				return true;
			}
			square[row][col] = bad;
		}
	} else {
		square[row][col] = value;
		if (recur(row, col+1, square)) { return true; }
		square[row][col] = bad;
	}
	return false;
}
vector<ll> force(vector<vector<ll>> square) {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			ll value = place(i, j, square);
			if (value != bad) {return {i, j, value};}
		}
	}
	return {-1};
}
ll place(int row, int col, vector<vector<ll>> square) {
	if (checkRow(row, col, square) == 1) {
		return getValue({square[row][0], square[row][1], square[row][2]});
	} else if (checkRow(row, col, square) == 0) {
		return getValue({square[0][col], square[1][col], square[2][col]});
	}
	return bad;
}
int checkRow(int row, int col, vector<vector<ll>> square) {
	ll temp = square[row][col];
	if (square[row][col] != bad) {return -1;}
	square[row][col] = 0;
	if (square[row][0] != bad && square[row][1] != bad && square[row][2] != bad) {
		square[row][col] = temp;
		return 1;
	} else if (square[0][col] != bad && square[1][col] != bad && square[2][col] != bad) {
		square[row][col] = temp;
		return 0;
	}
	return -1;
}
ll getValue(vector<ll> row) {
	if (row[0] == bad) {
		return row[1] - (row[2]-row[1]);
	} else if (row[1] == bad) {
		return row[0] + (row[2] - row[0])/2;
	} else {
		return row[1] + (row[1] - row[0]);
	}
}
bool check(vector<vector<ll>> square) {
	for (int i = 0; i < 3; i++) {
		if (square[1][i] - square[0][i] != square[2][i] - square[1][i]) {return false;}
		if (square[i][1] - square[i][0] != square[i][2] - square[i][1]) {return false;}
	}
	return true;
}
