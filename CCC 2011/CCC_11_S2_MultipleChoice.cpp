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

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int n, count = 0; vector<string> correct; string val; cin >> n;
	loopX(n) {cin >> val; correct.pb(val);}
	loopX(n) {cin >> val; if (val == correct[i]) {count++;}}
	cout << count << endl;
	return 0;
}
