#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define ll long long
#define LINF 100000000000000000

using namespace std;

int main() {
    int n; cin >> n;
    vector<pair<ll, ll> > pos;
    for (int i = 0; i < n; i++) {
        ll p, s, d; cin >> p >> s >> d;
        pos.push_back(make_pair(max(0ll, p - d), -s));
        pos.push_back(make_pair(p + d, s));
    } 
    sort(pos.begin(), pos.end());

    vector<ll> costs((int) pos.size());
    ll ans = LINF, last = 0, cost = 0, add = 0;

    for (int i = 0; i < (int) pos.size(); i++) {
        pair<ll, ll> val = pos[i];
        cost += (val.first - last) * add;
        if (val.second > 0) { add += val.second; }

        costs[i] = cost;
        last = val.first;
    }

    last = LINF, cost = 0, add = 0;
    for (int i = (int) pos.size() - 1; i >= 0; i--) {
        pair<ll, ll> val = pos[i];
        cost += (last - val.first) * add;
        if (val.second < 0) { add += val.second * -1ll; }

        costs[i] += cost;
        ans = min(ans, costs[i]);
        last = val.first;
    }

    cout << ans << endl;
} 