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
	ios_base::sync_with_stdio(0);
	int n; cin >> n;
	string let, num, bignum, output = "";
	vector<pair<string, string>> values;
	loopX(n) {
		cin >> let >> num; values.pb({let, num});
	}
	cin >> bignum;
	string current = "";
	loopX(bignum.length()) {
		current += bignum[i];
		for (pair<string, string> value : values) {
			if (current == value.second) {output += value.first; current = "";}
		}
	}
	cout << output << endl;
	return 0;
}
