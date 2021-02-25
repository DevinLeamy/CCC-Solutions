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

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	double e, c, t; cin >> e; vector<pair<double, double>> values; double maxSpeed = -1;
	
	for (int i = 0; i < e; i++) {
		cin >> c >> t;
		values.pb({c, t});
	}
	sort(values.begin(), values.end());
	pair<double, double> cur = values[0];
	for (int i = 1; i < values.size(); i++) {
		pair<double, double> newCur = values[i];
		double cT = newCur.first - cur.first;
		double cD = abs(newCur.second - cur.second);
		double speed = cD / cT;
		maxSpeed = max(speed, maxSpeed);
		cur = newCur;
	}
	ll speed = maxSpeed * 10;
	cout << speed / (double)10 << endl;
	return 0;
}

