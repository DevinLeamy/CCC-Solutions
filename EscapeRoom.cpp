#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#include <map>
#include <iomanip>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define PI pair<int, int>
#define ll long long
#define pb push_back
using namespace std;
char _;

int n, m, a;
bool isValid(int row, int col) {
	if (row >= n || row < 0 || col >= m || col < 0) {return false;}
	return true;
}
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	 cin >> n >> m;
	vector<vector<int>> maze(n); vector<vector<bool>> visited(n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j  <m; j++)  {
			visited[i].pb(false);
			cin >> a;
			maze[i].pb(a);
		}
	}
	queue<PI> cur; cur.push({0, 0});
	bool found = false;
	while (!found && !cur.empty()) {
		PI val = cur.front(); cur.pop();
		int row = val.first; int col = val.second;
		if (visited[row][col]) {continue;}
		if (row == n-1 && col == m-1) {
			found = true;
			continue;
		}
		visited[row][col] = true;
		int currentValue = maze[row][col];
		int maxValue = sqrt(currentValue);
		for (int i = 1; i <= maxValue; i++) {
			if (currentValue % i == 0) {
				int newRow = currentValue / i;
				int newCol = i;
				newRow--; newCol--;
				if (isValid(newRow, newCol) && !visited[newRow][newCol]) {
					cur.push({newRow, newCol});
				}
				if (isValid(newCol, newRow) && !visited[newCol][newRow]) {
					cur.push({newCol, newRow});
				}
			}
		}
	}
	if (found) {
		cout << "yes" << endl;
	} else {
		cout << "no" << endl;
	}
	return 0;
}
