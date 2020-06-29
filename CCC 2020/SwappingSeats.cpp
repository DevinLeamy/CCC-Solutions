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

int swaps(int a, int b) {
	return min(a, b) + (max(a, b) - min(a, b));
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	string s; cin >> s;
	vector<string> per = {"ACB", "ABC", "BCA", "BAC", "CAB", "CBA"};
	int as = 0;
	int bs = 0;
	int cs = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'A') { as++; }
		else if (s[i] == 'B') { bs++; }
		else { cs++; }
	}
	int aLp = 0;
	int aRp = as-1;
	int bLp = as;
	int bRp = as + bs - 1;
	int aM = 0;
	int bM = 0;
	int c = 0;
	for (int i = 0; i < as; i++) {
		if (s[i] == 'B') { aM++; }
		else if (s[i] == 'C') { c++; }
	}
	for (int i = as; i < as + bs; i++) {
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
	aLp = bs;
	aRp = as + bs - 1;
	bLp = 0;
	bRp = bs - 1;
	aM = 0;
	bM = 0;
	c = 0;
	for (int i = bs; i < as + bs; i++) {
		if (s[i] == 'B') { aM++; }
		else if (s[i] == 'C') { c++; }
	}
	for (int i = 0; i < bs; i++) {
		if (s[i] == 'A') { bM++; }
		else if (s[i] == 'C') { c++; }
	}
	min = std::min(swaps(aM, bM) + c, min);
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
	cout << min << endl;
	return 0;
}
