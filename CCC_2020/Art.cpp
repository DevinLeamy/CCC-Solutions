#include <iostream>
#include <string>

using namespace std;

int main() {
	int n; cin >> n;
	int largestX = -1;
	int smallestX = 101;
	int largestY = -1;
	int smallestY = 101;
	for (int i = 0; i < n; i++) {
		int x; string s; int y; cin >> x >> s;
		y = stoi(s.substr(1, s.length()));
		largestX = max(largestX, x);
		smallestX = min(smallestX, x);
		largestY = max(largestY, y);
		smallestY = min(smallestY, y);
	}
	cout << smallestX-1 << "," << smallestY-1 << endl;
	cout << largestX+1 << "," << largestY+1 << endl;
	return 0;
}

