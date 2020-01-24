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
#define doH(h) for(int i = 0; i < h; i++)

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	PI nik; cin >> nik.first >> nik.second;
	PI bar; cin >> bar.first >> bar.second;
	int s; cin >> s;
	bool n = true; bool b = true;
	int distN = 0; int distB = 0;
	int curN = nik.first; int curB = bar.first;
	while (s > 0) {
		distN += (n)? 1 : -1;
		distB += (b)? 1 : -1;
		curN--; curB--; s--;
		if (curN == 0) {n = !n; curN = (n)? nik.first : nik.second;}
		if (curB == 0) {b = !b; curB = (b)? bar.first : bar.second;}
	}
	if (distB == distN) {cout << "Tied" << endl;}
	else {cout << ((distB > distN)? "Byron" : "Nikky") << endl;}
	return 0;
}
