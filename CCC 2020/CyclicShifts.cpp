#include <iostream>

using namespace std;

int main() {
	string t, s; cin >> t >> s;
	if (s.length() > t.length()) {
		cout << "no" << endl;
		return 0;
	}
	for  (int i = 0; i < s.length(); i++) {
		for (int j = 0; j < t.length() - s.length() + 1; j++) {
			int cur = i;
			bool works = true;
			for (int k = 0; k < s.length(); k++) {
				if (s[cur] != t[j + k]) {
					works = false;
					break;
				}
				cur++;
				cur %= s.length();
			}
			if (works) {
				cout << "yes" << endl;
				return 0;
			}
		}
	}
	cout << "no" << endl;
	return 0;
}

