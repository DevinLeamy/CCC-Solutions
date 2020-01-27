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

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n; ll T; ll count = 0; ll rt, rb, cl, cr, t;
	vector<pair<ll, ll>> tintsX; vector<pair<ll, pair<ll, ll>>> tintY;
	cin >> n >> T;
	loop(n) {
		cin >> cl >> rb >> cr >> rt >> t;
		tintsX.pb({cl, i}); tintsX.pb({cr, i});
		tintY.pb({rb, {t, i}}); tintY.pb({rt, {-t, i}});
	}
	sort(tintsX.begin(), tintsX.end());
	sort(tintY.begin(), tintY.end());
	vector<ll> ids;
	for (int i = 0; i < tintsX.size()-1; i++) {
		pair<ll, ll> val = tintsX[i];
		ll x = val.first; ll id = val.second;
		
		if (find(ids.begin(), ids.end(), id) != ids.end()) {
			ids.erase(find(ids.begin(), ids.end(), id));
		} else {
			ids.pb(id);
		}
		ll last = -1; ll currentTint = 0;
		for (int j = 0; j < tintY.size(); j++) {
			if (find(ids.begin(), ids.end(), tintY[j].second.second) != ids.end()) {
				pair<ll, pair<ll, ll>> h = tintY[j];
				if (last == -1) {
					last = h.first;
					currentTint += h.second.first;
				} else {
					if (currentTint >= T) {
						count += (abs(last - h.first)) * (abs(x - tintsX[i+1].first));
					}
					last = h.first;
					currentTint += h.second.first; 
				}
			}
		}
	}
	cout << count << endl;
	return 0;
}
