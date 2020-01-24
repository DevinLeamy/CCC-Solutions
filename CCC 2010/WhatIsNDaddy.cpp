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
	int n; cin >> n; int count = 0;
	for (int i = 0; i <= 5; i++) {
		int left = max(0, max(5, n) - i); int right = n - left;
		if (left >= right && left + right == n && right >= 0 && left < 6) {count++;}
	}
	cout << count << endl;
	return 0;
}
