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

string s;

int swaps(int a, int b) {
	return max(a, b);
}

int check(int aLp, int aRp, int bLp, int bRp, int aS, int aE, int bS, int bE) {
	int aM = 0;
	int bM = 0;
	int c = 0;
	for (int i = aS; i < aE; i++) {
		if (s[i] == 'B') { aM++; }
		else if (s[i] == 'C') { c++; }
	}
	for (int i = bS; i < bE; i++) {
		if (s[i] == 'A') { bM++; }
		else if (s[i] == 'C') { c++; }
	}
	int min = swaps(aM, bM) + c;
	for (int i = 0; i < s.length(); i++) {
		aRp = (aRp + 1) % s.length();
		bRp = (bRp + 1) % s.length();
		if (s[aLp] == 'B') { aM--; }
		else if (s[aLp] == 'C') { c--; }
		if (s[aRp] == 'B') { aM++; }
		else if (s[aRp] == 'C') { c++; }
		if (s[bLp] == 'A') { bM--; }
		else if (s[bLp] == 'C') { c--; }
		if (s[bRp] == 'A') { bM++; }
		else if (s[bRp] == 'C') { c++; }
		min = std::min(swaps(aM, bM) + c, min);
		bLp = (bLp + 1) % s.length();
		aLp = (aLp + 1) % s.length();
	}
	return min;
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> s;
	int as = 0;
	int bs = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'A') { as++; }
		else if (s[i] == 'B') { bs++; }
	}
	cout << min(check(0, as - 1, as, as + bs - 1, 0, as, as, as + bs), check(bs, as + bs - 1, 0, bs - 1, bs, as + bs, 0, bs));
	return 0;
}
