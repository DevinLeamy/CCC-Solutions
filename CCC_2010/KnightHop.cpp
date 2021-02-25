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

bool visited[8][8];
bool isValid(int, int);
int main() {
	ios_base::sync_with_stdio(0);
	int rS, cS, rE, cE;
	cin >> cS >> rS >> cE >> rE;
	rS = 8-rS; rE = 8-rE; cS--; cE--;
	queue< pair<PI, int> > queue;
	queue.push({{rS, cS}, 0});
	int minDist = 65;
	while (queue.size()) {
		pair< PI, int> value = queue.front(); queue.pop();
		int row = value.first.first; int col = value.first.second;
		int dist = value.second;
		if (row == rE && col == cE) {minDist = min(minDist, dist);}
		else if (!visited[row][col]) {
			visited[row][col] = true;
			if (isValid(row+1, col+2)) {queue.push( {{row + 1, col + 2}, dist+1});}
			if (isValid(row-1, col+2)) {queue.push( {{row - 1, col + 2}, dist+1});}
			if (isValid(row-1, col-2)) {queue.push( {{row - 1, col - 2}, dist+1});}
			if (isValid(row+1, col-2)) {queue.push( {{row + 1, col - 2}, dist+1});}
			if (isValid(row+2, col+1)) {queue.push( {{row + 2, col + 1}, dist+1});}
			if (isValid(row-2, col+1)) {queue.push( {{row - 2, col + 1}, dist+1});}
			if (isValid(row+2, col-1)) {queue.push( {{row + 2, col - 1}, dist+1});}
			if (isValid(row-2, col-1)) {queue.push( {{row - 2, col - 1}, dist+1});}
		}
	}
	cout << minDist << endl;
	return 0;
}
bool isValid(int row, int col) {
	if (row < 0 || row >= 8 || col < 0 || col >= 8 || visited[row][col]) {
		return false;
	}
	return true;
}

