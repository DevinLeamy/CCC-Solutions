#include <iostream>

using namespace std;

int main() {
	int s, m, l; cin >> s >> m >> l;
	if (s + m * 2 + l * 3 >= 10) cout << "happy" << endl;
	else cout << "sad" << endl;
	return 0;
}
