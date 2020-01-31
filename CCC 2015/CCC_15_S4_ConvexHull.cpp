#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#include <map>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define PI pair<int, int>
#define ll long long
#define pb push_back
#define loop(h) for(int i = 0; i < h; i++)

using namespace std;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	ll hull, n, m, p1, p2, t, h, a, b;
	cin >> hull >> n >> m;
	vector<vector<pair<ll,PI>>> adj;
	vector<pair<ll, ll>> best;
	for (int i = 0; i < n; i++) {
		adj.pb(vector<pair<ll, PI>>());
		best.pb({2147483647, 2147483647});
	}
	for (int i = 0; i < m; i++) {
		cin >> p1 >> p2 >> t >> h;
		p1--; p2--;
		adj[p1].push_back({t, {p2, h}});
		adj[p2].push_back({t, {p1, h}});
	}
	cin >> a >> b; a--;  b--;
	queue<pair<ll, PI>> next;
	next.push( {0, {a, 0}} );
	ll currentMin = 2147483647;
	while (!next.empty()) {
		pair<ll, PI> value = next.front(); next.pop();
		ll time = value.first; ll node = value.second.first; ll wear = value.second.second;
		if (time >= currentMin || wear >= hull) {continue;}
		if (best[node].first <= time && best[node].second <= wear) {continue;}
		else if (best[node].first >= time) {
			best[node].first = time;
			best[node].second = wear;
		}
		if (node == b) {currentMin = min(currentMin, time); continue;}
		for (pair<ll, PI> other : adj[node]) {
			if (other.second.second + wear >= hull) {continue;}
			else if (other.first + time >= currentMin) {continue;}
			next.push({time + other.first, {other.second.first, other.second.second + wear}});
		}
	}
	if (currentMin == 2147483647) { cout << -1 << endl; }
	else { cout << currentMin << endl; }
	return 0;
}
