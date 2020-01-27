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
	vector<pair<ll, pair< pair<ll, ll>, ll> >> tintsX;
	cin >> n >> T;
	loop(n) {
		cin >> cl >> rb >> cr >> rt >> t;
		tintsX.pb({cl, { {rb, rt}, t }}); tintsX.pb({cr, { {rb, rt}, -t }});
	}
	sort(tintsX.begin(), tintsX.end());
	vector<ll> ids;
	vector< pair<ll, ll> > tints;
	for (int i = 0; i < tintsX.size()-1; i++) {
		pair<ll, pair< pair<ll, ll>, ll> > item = tintsX[i];
		ll x = item.first;
		ll last = -1; ll currentTint = 0;
		if (item.second.second < 0) {
			tints.erase( find(tints.begin(), tints.end(), make_pair(item.second.first.first, -item.second.second) ) );
			tints.erase( find(tints.begin(), tints.end(), make_pair(item.second.first.second, item.second.second) ) );
		} else {
			tints.pb({item.second.first.first, item.second.second});
			tints.pb({item.second.first.second, -item.second.second});
			sort(tints.begin(), tints.end());
		}
		for (int j = 0; j < tints.size(); j++) {
			pair<ll, ll> h = tints[j];
			if (last == -1) {
				last = h.first;
				currentTint += h.second;
			} else {
				if (currentTint >= T) {
					count += (abs(last - h.first)) * (abs(x - tintsX[i+1].first));
				}
				last = h.first;
				currentTint += h.second;
			}
		}
		
	}
	cout << count << endl;
	return 0;
}
