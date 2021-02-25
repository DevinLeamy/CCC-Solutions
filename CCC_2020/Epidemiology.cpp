#include <iostream>
#include <cmath>
using namespace std;

int main() {
	long long p, n; int r; cin >> p >> n >> r;
	int cur = 0;
	long long inf = n;
	long long total = n;
	while (1) {
		long long newInf = inf * r;
		total += newInf;
		inf = newInf;
		cur++;
		if (total > p) break;
	}
	cout << cur << endl;
	return 0;
}
