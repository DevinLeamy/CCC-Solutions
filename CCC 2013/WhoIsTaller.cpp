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

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int n, m, a, b, p, q;  cin >> n >> m;
	vector< vector<int> > taller;
	vector<bool> checked;
	loop(n) { taller.pb(vector<int>()); checked.pb(false); }
	loop(m) { cin >> a >> b; taller[a-1].pb(b-1); } //a-1 is taller than b-1
	cin >> p >> q; p--; q--;
	bool pIsTaller = false; bool qIsTaller = false;
	queue<int> small; small.push(p);
	while (small.size()) {
		int person = small.front(); small.pop();
		if (person == q) {pIsTaller = true; break;}
		if (!checked[person]) {
			checked[person] = true;
			for (int h : taller[person]) {
				if (!checked[h]) {
					small.push(h);
				}
			}
		}
	}
	while (small.size()) {small.pop();}
	loop(n) {checked[i] = false;}
	small.push(q);
	while (small.size()) {
		int person = small.front(); small.pop();
		if (person == p) {qIsTaller = true; break;}
		if (!checked[person]) {
			checked[person] = true;
			for (int h : taller[person]) {
				if (!checked[h]) {
					small.push(h);
				}
			}
		}
	}
	if (pIsTaller) {cout << "yes" << endl;}
	else if (qIsTaller) {cout << "no" << endl;}
	else {cout << "unknown" << endl;}
	return 0;
}
