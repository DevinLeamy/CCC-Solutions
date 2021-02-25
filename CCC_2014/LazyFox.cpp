// 9/15

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

double getDistance(PI, PI);
vector<int> best;
int getBest(pair<double, pair<PI, PI>>, int, int);
vector<pair<double, pair<PI, PI>>> distances;
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, x, y; cin >> n;
	vector<pair<int, int>> houses; houses.pb({0, 0});

	loop(n) {
		cin >> x >> y;
		houses.pb({x, y});
	}
	for (int i = 0; i < houses.size(); i++) {
		for (int j = i+1; j < houses.size(); j++) {
			double distance = getDistance(houses[i], houses[j]);
			distances.pb({distance, {houses[i], houses[j]}});
			if (houses[i] != make_pair(0, 0)) {
				distances.pb({distance, {houses[j], houses[i]}});
				best.pb(-1);
			}
			best.pb(-1);
		}
	}
	sort(distances.rbegin(), distances.rend());
	int currentBest = -1;
	for (int i = 0; i < distances.size(); i++) {
		if (distances[i].second.first == make_pair(0, 0)) {
			if (best[i] != -1) {
				currentBest = max(currentBest, best[i]);
			} else {
				currentBest = max(getBest(distances[i], i, 1), currentBest);
			}
		}
	}
	cout << currentBest << endl;
	return 0;
}
double getDistance(PI a, PI b) {
	int x = a.first - b.first;
	int y = a.second - b.second;
	return sqrt( (x*x) + (y*y) );
}
int getBest(pair<double, pair<PI, PI>> current, int index, int currentTreats) {
	if (best[index] != -1) {
		return best[index];
	}
	int currentBest = 1;
	bool found = false;
	for (int i = index+1; i < distances.size(); i++) {
		if (distances[i].second.first == current.second.second && current.first > distances[i].first) {
			found = true;
			if (best[i] != -1) {
				currentBest = max(currentBest, best[i]);
			} else {
				currentBest = max(getBest(distances[i], i, 1), currentBest);
			}
		}
	}
	if (!found) {
		best[index] = 1;
	} else {
		best[index] = currentTreats + currentBest;
	}
	return best[index];
}
