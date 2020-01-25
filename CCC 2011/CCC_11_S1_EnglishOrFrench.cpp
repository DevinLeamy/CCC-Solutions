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
	int t=0, s=0, n; cin >> n;
	string line;
	for (int i = 0; i < n; i++) {
		getline(cin, line);
		for (int j = 0; j < line.length(); j++) {
			if (line[j] == 't' || line[j] == 'T') {t++;}
			if (line[j] == 's' || line[j] == 'S') {s++;}
		}
	}
	cout << ((t >= s)? "English" : "French") << endl;
	return 0;
}
