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

//Order of Giving: O-, A-, B-, AB-, O+, A+, B+, AB+
// Order of Input: O-, O+, A-, A+, B-, B+, AB-, AB+
vector<int> bloods; vector<int> pat; int val; int total = 0;
void dist(int);
void give(int, vector<int>);
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	loopX(8) { cin >> val; bloods.pb(val); }
	loopX(8) { cin >> val; pat.pb(val); }
	give(0, {0}); give(2, {0, 2});
	give(4, {0, 4}); give(6, {0, 2, 4, 6});
	give(1, {0, 1}); give(3, {0, 1, 2, 3});
	give(5, {0, 1, 4, 5}); give(7, {0, 1, 2, 3, 4, 5, 6, 7});
	cout << total << endl;
	return 0;
}
void give(int type, vector<int> canTake) {
	reverse(canTake.begin(), canTake.end());
	for (int i = 0; i < canTake.size(); i++) {
		int give = min(pat[type], bloods[canTake[i]]);
		pat[type] -= give; bloods[canTake[i]] -= give; total += give;
		if (pat[type] == 0) {return;}
	}
}
